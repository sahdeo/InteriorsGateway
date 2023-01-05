package com.stockroute.designerservice.designer.service;
import com.stockroute.designerservice.design.exception.DesignNotFoundException;
import com.stockroute.designerservice.design.model.Design;
import com.stockroute.designerservice.design.repository.DesignRepository;
import com.stockroute.designerservice.designer.exception.IdNotFound;
import com.stockroute.designerservice.designer.exception.ProfileAlreadyExit;
import com.stockroute.designerservice.designer.model.Designer;
import com.stockroute.designerservice.designer.repository.DesignerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class DesignerServiceImpl implements DesignerService{

    @Autowired
    DesignerRepository designerRepository;
    @Autowired
    private DesignRepository designRepository;

    @Override
    public Designer saveDesigner(Designer designer) throws ProfileAlreadyExit {
        designer.setStartDate(LocalDateTime.now());
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


    @Override
    public Designer updateDesigner(Designer designer) {
        return null;
    }

    @Override
    public Boolean  deleteDesignerByDesignerId(String designerId) throws IdNotFound {
        Designer designer=findDesignerByDesignerId(designerId);
        if(designer.getDesignerId().isBlank()){

            throw  new IdNotFound("designer Id is not found");
        }
        designerRepository.deleteById(designerId);
        return true;
    }

    @Override
    public String deleteAllOrders() {
        designerRepository.deleteAll();
        return "Clear order history successfully";
    }

    @Override
    public Designer findDesignerByDesignerId(String designerId) throws IdNotFound {
        Optional<Designer> designerOptinal = designerRepository.findById(designerId);

        if (designerOptinal.isEmpty()) {
            throw new IdNotFound();
        }
        return designerOptinal.get();

    }
}
