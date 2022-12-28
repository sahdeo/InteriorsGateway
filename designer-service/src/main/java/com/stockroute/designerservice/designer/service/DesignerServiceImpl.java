package com.stockroute.designerservice.designer.service;
import com.stockroute.designerservice.design.repository.DesignRepository;
import com.stockroute.designerservice.designer.exception.ProfileAlreadyExit;
import com.stockroute.designerservice.designer.model.Designer;
import com.stockroute.designerservice.designer.repository.DesignerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class DesignerServiceImpl implements DesignerService{

    @Autowired
    DesignerRepository designerRepository;
    @Autowired
    private DesignRepository designRepository;

    @Override
    public Designer saveDesigner(Designer designer) throws ProfileAlreadyExit {
        if (this.designerRepository.findById(designer.getDesignerId()).isPresent()) {
            throw new ProfileAlreadyExit();
        }
        return designerRepository.save(designer);

    }

    @Override
    public List<Designer> getAllDesigners() {
        return designerRepository.findAll();
    }

    @Override
    public List<Designer> findDesignersByEmailId(String EmailId) {
        return designerRepository.findDesignerByEmailId(EmailId);
    }

//    @Override
//    public List<Designer> findDesignersById(String designerId) {
//        return designerRepository.findByDesignerId(designerId);
//    }


    @Override
    public Designer updateDesigner(Designer designer) {
        return null;
    }

    @Override
    public List<Designer> deleteDesignerById(String designerId) {
        return designerRepository.deleteDesignerByEmailId(designerId);

    }

    @Override
    public String deleteAllOrders() {
        designerRepository.deleteAll();
        return "Clear order history successfully";
    }
}
