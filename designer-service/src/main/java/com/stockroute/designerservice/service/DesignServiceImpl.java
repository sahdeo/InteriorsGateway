package com.stockroute.designerservice.service;

import com.stockroute.designerservice.exception.DesignAlreadyExistsException;
import com.stockroute.designerservice.exception.DesignNotFoundException;
import com.stockroute.designerservice.model.Design;
import com.stockroute.designerservice.repository.DesignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DesignServiceImpl implements DesignService {
    private DesignRepository designRepository;
    @Autowired
    public DesignServiceImpl(DesignRepository designRepository) {
        this.designRepository = designRepository;
    }

    @Override
    public Design saveDesign(Design design) throws DesignAlreadyExistsException{
        if (designRepository.findById(design.getDesignId()).isPresent()) {
            throw new DesignAlreadyExistsException();
        }
        return designRepository.save(design);
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
    public List<Design> getDesignDetails() throws Exception {
        return designRepository.findAll();
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
}
