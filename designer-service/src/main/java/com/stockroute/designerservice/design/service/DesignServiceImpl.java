package com.stockroute.designerservice.design.service;
import com.stockroute.designerservice.design.exception.DesignAlreadyExistsException;
import com.stockroute.designerservice.design.exception.DesignNotFoundException;
import com.stockroute.designerservice.design.model.Design;
import com.stockroute.designerservice.design.rabbitmqConfig.Producer;
import com.stockroute.designerservice.design.repository.DesignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DesignServiceImpl implements DesignService {
    private DesignRepository designRepository;

    private Producer producer;


    @Autowired
    public DesignServiceImpl(DesignRepository designRepository) {
        this.designRepository = designRepository;
    }

    @Override
    public Design saveDesign(Design design) throws DesignAlreadyExistsException {
        if (designRepository.findById(design.getDesignId()).isPresent()) {
            throw new DesignAlreadyExistsException();
        }
        producer.sendMessageToRabbitmq(design);
        return designRepository.save(design);
    }

    @Override
    public Design uploadImage(String designId, MultipartFile file) throws IOException, DesignNotFoundException {
        Optional<Design> designOptinal = designRepository.findById(designId);

        if (designOptinal.isEmpty()) {
            throw new DesignNotFoundException();
        }
        Design design = designOptinal.get();
        design.setImage(file.getBytes());
        designRepository.save(design);
        return design;
    }


    @Override
    public boolean deleteDesign(String designId) throws DesignNotFoundException {
        boolean flag = false;
        if (designRepository.findById(designId).isEmpty()) {
            throw new DesignNotFoundException();
        } else {
            designRepository.deleteById(designId);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Design> getAllDesign(int design) throws DesignNotFoundException {
        if (designRepository.findAllDesignFromCode(design).isEmpty()) {
            throw new DesignNotFoundException();
        }
        return designRepository.findAllDesignFromCode(design);
    }

    @Override
    public Design updateDesign(Design design, String designId) {
        if (designRepository.findById(designId).isEmpty()) {
            return null;
        }
        return designRepository.save(design);
    }

    @Override
    public List<Design> getDesignDetails() throws Exception {
        return designRepository.findAll();
    }

    @Override
    public Design findDesignByDesignId(String designId) throws DesignNotFoundException {
        Optional<Design> designOptinal = designRepository.findById(designId);

        if (designOptinal.isEmpty()) {
            throw new DesignNotFoundException();
        }
        return designOptinal.get();

    }
}


