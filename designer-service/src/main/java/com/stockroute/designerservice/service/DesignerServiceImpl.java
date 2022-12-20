package com.stockroute.designerservice.service;

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
    public DesignerEntity saveDesigner(DesignerEntity designerEntity) {

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
