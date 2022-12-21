package com.stockroute.designerservice.designer.service;

import com.stockroute.designerservice.designer.exception.DesignerAlreadyExitsException;
import com.stockroute.designerservice.designer.exception.DesignerNotFoundException;
import com.stockroute.designerservice.designer.model.DesignerEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DesignerService {
    DesignerEntity saveDesigner(DesignerEntity designerEntity)throws DesignerAlreadyExitsException;

    List<DesignerEntity> getAllDesigners();

    List<DesignerEntity> findDesignersByDesignerId(String designerId);
    List<DesignerEntity> findDesignersByEmailId(String emailId);


    DesignerEntity updateDesigner(DesignerEntity designerEntity);

    List<DesignerEntity> deleteDesignerById(String designerId)throws DesignerNotFoundException;

    String deleteAllOrders();
}
