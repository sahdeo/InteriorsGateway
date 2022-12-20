package com.stockroute.designerservice.service;

import com.stockroute.designerservice.exception.DesignAlreadyExistsException;
import com.stockroute.designerservice.exception.DesignNotFoundException;
import com.stockroute.designerservice.model.Design;

import java.util.List;

public interface DesignService {
    Design saveDesign(Design design) throws DesignAlreadyExistsException;

    boolean deleteDesign(String designId) throws DesignNotFoundException;

    List<Design> getDesignDetails() throws Exception;

    List<Design> getAllDesign(int design) throws DesignNotFoundException;

    Design updateDesign(Design design, String designId);
}
