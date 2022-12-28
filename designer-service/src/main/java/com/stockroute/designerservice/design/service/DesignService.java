package com.stockroute.designerservice.design.service;

import com.stockroute.designerservice.design.exception.DesignAlreadyExistsException;
import com.stockroute.designerservice.design.exception.DesignNotFoundException;
import com.stockroute.designerservice.design.model.Design;
import com.stockroute.designerservice.design.repository.DesignRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DesignService {
    Design saveDesign(Design design) throws DesignAlreadyExistsException;

    boolean deleteDesign(String designId) throws DesignNotFoundException;
     Design uploadImage(String designId, MultipartFile file) throws IOException, DesignNotFoundException;

    List<Design> getDesignDetails() throws Exception;

    List<Design> getAllDesign(int design) throws DesignNotFoundException;

    Design updateDesign(Design design, String designId);
    Design findDesignByDesignId(String designId) throws DesignNotFoundException;
}

