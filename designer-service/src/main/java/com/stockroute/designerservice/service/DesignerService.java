package com.stockroute.designerservice.service;

import com.stockroute.designerservice.model.DesignerEntity;

import java.util.List;

public interface DesignerService {
    DesignerEntity saveDesigner(DesignerEntity designerEntity) ;

    List<DesignerEntity> getAllDesigners();

    List<DesignerEntity> findDesignersByDesignerId(String designerId);

    DesignerEntity updateDesigner(DesignerEntity designerEntity);

    List<DesignerEntity> deleteDesignerById(String designerId);

    String deleteAllOrders();
}
