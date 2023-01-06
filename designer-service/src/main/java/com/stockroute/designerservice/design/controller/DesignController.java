package com.stockroute.designerservice.design.controller;

import com.stockroute.designerservice.design.dto.UpdateDesign;
import com.stockroute.designerservice.design.exception.DesignAlreadyExistsException;
import com.stockroute.designerservice.design.exception.DesignNotFoundException;
import com.stockroute.designerservice.design.model.Design;
import com.stockroute.designerservice.design.service.DesignService;
import com.stockroute.designerservice.designer.model.Designer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/designerService")
@CrossOrigin("*")
public class DesignController {
    private DesignService designService;

    private ResponseEntity responseEntity;

    @Autowired
    public DesignController(DesignService designService) {
        this.designService = designService;
    }

    @PostMapping(value = "/upload image", consumes = {"multipart/form-data"})
    public ResponseEntity<?> saveImage(@RequestParam("designId") String designId, @RequestParam("file")MultipartFile file) throws IOException {
        try {
            responseEntity = new ResponseEntity<>(designService.uploadImage(designId, file), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return responseEntity;
    }

    @PostMapping("/design")
    public ResponseEntity<?> saveDesign(@RequestBody Design design) throws DesignAlreadyExistsException {
        try {
            designService.saveDesign(design);
            responseEntity = new ResponseEntity<>(design, HttpStatus.CREATED);
        } catch (DesignAlreadyExistsException e) {
            throw new DesignAlreadyExistsException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error try save after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;

    }
    @GetMapping("/design/details")
    public ResponseEntity<?> getDesignDetails() {
        try {
            List<Design> designList = designService.getDesignDetails();
            responseEntity = new ResponseEntity<>(designList, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error try save after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @GetMapping("/findByEmailId/{EmailId}")
    public ResponseEntity<List<Design>> getdesignerByEmailId(@PathVariable String EmailId) {
        List<Design> designerListByEmail=designService.findDesignersByEmailId(EmailId);
        return new ResponseEntity<>(designerListByEmail, HttpStatus.OK);
    }

    @DeleteMapping("/design/{designId}")
    public ResponseEntity<?> deleteDesign(@PathVariable String designId) throws DesignNotFoundException {
        try {
            designService.deleteDesign(designId);
            responseEntity = new ResponseEntity<>("Successfully deleted!!!!", HttpStatus.OK);
        } catch (DesignNotFoundException e) {
            throw new DesignNotFoundException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }
    @GetMapping("/design/{designCode}")
    public ResponseEntity<?> getAllDesign(@PathVariable int designCode) {
        try {
            responseEntity = new ResponseEntity(designService.getAllDesign(designCode), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error try save after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @PutMapping("/design/{designId}")
    public ResponseEntity<?> updateDesign(@RequestBody UpdateDesign design, @PathVariable("designId") String designId) {
        return new ResponseEntity<>(designService.updateDesign(design, designId), HttpStatus.OK);
    }
    @GetMapping("/findByDesignId/{designId}")
    public ResponseEntity<?> getUserByDesigneId(@PathVariable String designId) throws DesignNotFoundException {
        return new ResponseEntity<>(designService.findDesignByDesignId(designId), HttpStatus.OK);
    }

}

