package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.dao.IUserDao;
import com.stackroute.authenticationservice.dto.OtpVerify;
import com.stackroute.authenticationservice.entity.User;
import com.stackroute.authenticationservice.exception.OtpNotValidException;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
import com.stackroute.authenticationservice.otpservice.OtpGenerator;
import com.stackroute.authenticationservice.rabbitmqConfig.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rabbitmq.domain.EmailDto;
import rabbitmq.domain.UserDto;

import java.util.Optional;


@Service
public class UserServiceImp implements IUserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImp.class);

    private IUserDao userDao;
    private Producer producer;
    private PasswordEncoder passwordEncoder;
    private OtpGenerator otpGenerator;
    @Autowired
    public UserServiceImp(IUserDao userDao, Producer producer, OtpGenerator otpGenerator, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.producer = producer;
        this.otpGenerator=otpGenerator;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public User registerNewUser(User user) {
        UserDto userDto= new UserDto();
        userDto.setEmailId(user.getEmailId());
        userDto.setUserPassword(user.getUserPassword());
        userDto.setUserFirstName(user.getUserFirstName());
        userDto.setUserLastName(user.getUserLastName());
        userDto.setMobileNo(user.getMobileNo());
        userDto.setRole(user.getRole());

        producer.sendMessageToRabbitmqReg(userDto);

        return userDao.save(user);
    }

    @Override
    public User findByUsername(String emailId) throws UserNotFoundException {
        Optional<User> optional = userDao.findById(emailId);
        if (optional.isEmpty()) {
            throw new UserNotFoundException("username is missing");
        }
        return optional.get();
    }

    @Override
    public String updatePassword(OtpVerify otpVerify) throws UserNotFoundException, OtpNotValidException {

        if(validateOTP(otpVerify.getEmailId(),otpVerify.getOtp())){

           User user = findByUsername(otpVerify.getEmailId());
           user.setUserPassword(otpVerify.getNewPassword());
//        System.out.println(user.getUserPassword());
           userDao.save(user);
           return "Success";
       }
       throw new OtpNotValidException("OTP is not valid");
    }
    /**
     * Method for generate OTP number
     *
     * @param emailId - provided key (username in this case)
     * @return boolean value (true|false)
     */

    @Override
    public EmailDto forgotPassword(String emailId) throws UserNotFoundException {
        // generate otp
        Integer otpValue = otpGenerator.generateOTP(emailId);
        if (otpValue == -1)
        {
            LOGGER.error("OTP generator is not working...");
        }
        EmailDto emailDTO = new EmailDto();
        emailDTO.setEmailId(emailId);
        emailDTO.setOtp(otpValue);
        producer.sendMessageToRabbitmq(emailDTO);
        return emailDTO;
    }


    /**
     * Method for validating provided OTP
     *
     * @param key - provided key
     * @param otpNumber - provided OTP number
     * @return boolean value (true|false)
     */
    public Boolean validateOTP(String key, Integer otpNumber)
    {
        // get OTP from cache
        Integer cacheOTP = otpGenerator.getOPTByKey(key);
        if (cacheOTP!=null && cacheOTP.equals(otpNumber))
        {
            otpGenerator.clearOTPFromCache(key);
            return true;
        }
        return false;
    }

    public PasswordEncoder getEncodedPassword(String password) {
        return new BCryptPasswordEncoder();
    }

}