package com.stockroute.designerservice.service;

import com.stockroute.designerservice.exception.DesignAlreadyExistsException;
import com.stockroute.designerservice.exception.DesignerAlreadyExitsException;
import com.stockroute.designerservice.model.DesignerEntity;
import com.stockroute.designerservice.repository.DesignerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DesignerServiceImpl implements DesignerService{
@Autowired
private DesignerRepository designerRepository;
    @Override
    public DesignerEntity saveDesigner(DesignerEntity designerEntity)throws DesignerAlreadyExitsException {

        if (designerRepository.findById(designerEntity.getDesignerId()).isPresent()) {
            throw new DesignerAlreadyExitsException();
        }
        return designerRepository.save(designerEntity);
    }

    @Override
    public List<DesignerEntity> getAllDesigners() {
        return designerRepository.findAll();
    }

    @Override
    public List<DesignerEntity> findDesignersByDesignerId(String designerId) {
        return designerRepository.findByDesignerId(designerId);
    }

    @Override
    public List<DesignerEntity> findDesignersByEmailId(String emailId) {
        return designerRepository.findByEmailId(emailId);
    }

    @Override
    public DesignerEntity updateDesigner(DesignerEntity designerEntity) {
        return null;
    }

    @Override
    public List<DesignerEntity> deleteDesignerById(String designerId) {
        return designerRepository.deleteDesignerByDesignerId(designerId);
    }

    @Override
    public String deleteAllOrders() {
         designerRepository.deleteAll();
         return "All designers accounts are deleted";
    }
}
