package com.stockroute.designerservice.service;

import com.stockroute.designerservice.exception.DesignerAlreadyExitsException;
import com.stockroute.designerservice.exception.DesignerNotFoundException;
import com.stockroute.designerservice.model.DesignerEntity;


import java.util.List;

public interface DesignerService {
    DesignerEntity saveDesigner(DesignerEntity designerEntity)throws DesignerAlreadyExitsException;

    List<DesignerEntity> getAllDesigners();

    List<DesignerEntity> findDesignersByDesignerId(String designerId);
    List<DesignerEntity> findDesignersByEmailId(String emailId);


    DesignerEntity updateDesigner(DesignerEntity designerEntity);

    List<DesignerEntity> deleteDesignerById(String designerId)throws DesignerNotFoundException;

    String deleteAllOrders();
}
