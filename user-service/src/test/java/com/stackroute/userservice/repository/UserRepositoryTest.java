///*package com.stackroute.userservice.repository;
//
//
//import com.stackroute.userservice.dto.AddUser;
//import com.stackroute.userservice.dto.UserDetails;
//import com.stackroute.userservice.entity.Role;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class UserRepositoryTest {
//
//    @Autowired
//    private IUserRepository userRepository;
//
//    private AddUser user1;
//    private UserDetails UserDetails1, UserDetails2;
//
//    @BeforeEach
//    public void setUp() {
//        user1 = new AddUser("Ravi1","Ravi@gmail.com","Ravi","Gelda","Ravi@123","Ravi@123","7879644891", Role.CUSTOMER);
//        UserDetails1 = new UserDetails("Ravi@gmail.com","Ravi1","Ravi","Gelda","Ravi@123","Ravi@123","7879644891",Role.CUSTOMER);
//
//
//    }
//
//    @AfterEach
//    public void tearDown() {
//        user1 = null;
//        UserDetails1 = null;
//        //productDetails2 = null;
//        userRepository.deleteAll();
//    }
//
//    /*@Test
//    public void UserRegisterTest() {
//        userRepository.insert(user1);
//        AddUser addUser =
//        assertNotNull(addUser);
//        assertEquals(user1.getUserName(), addUser.getUserName());
//    }
//
//
//    @Test
//    public void givenTrackReturnAllProduct() {
//        productRepository.insert(product);
//
//        List<Product> list = productRepository.findAll();
//        assertEquals(1, list.size());
//        assertEquals("laptop", list.get(0).getProductName());
//    }
//
//
//    @Test
//    public void givenProductToDeleteShouldReturnDeleteProduct() {
//        productRepository.insert(product);
//        Product product1 = productRepository.findById(product.getProductId()).get();
//        productRepository.delete(product1);
//        assertEquals(Optional.empty(), productRepository.findById(product1.getProductId()));
//
//    }
//}
//
//
//}
//
//
//     */