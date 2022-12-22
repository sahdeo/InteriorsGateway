package com.stockroute.designerservice.design.service;

import com.stockroute.designerservice.design.exception.DesignAlreadyExistsException;
import com.stockroute.designerservice.design.exception.DesignNotFoundException;
import com.stockroute.designerservice.design.model.Design;
import com.stockroute.designerservice.design.repository.DesignRepository;
import java.util.List;

public interface DesignService {
    Design saveDesign(Design design) throws DesignAlreadyExistsException;

    boolean deleteDesign(String designId) throws DesignNotFoundException;

    List<Design> getDesignDetails() throws Exception;

    List<DesignRepository> getAllDesign(int design) throws DesignNotFoundException;

    Design updateDesign(Design design, String designId);
    List<DesignRepository> findDesignByDesignId(String designId);
}

