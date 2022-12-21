package com.stockroute.designerservice.controller;
import com.stockroute.designerservice.exception.DesignAlreadyExistsException;
import com.stockroute.designerservice.exception.DesignNotFoundException;
import com.stockroute.designerservice.model.Design;
import com.stockroute.designerservice.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/")
public class DesignController {
    private DesignService designService;

    private ResponseEntity responseEntity;

    @Autowired
    public DesignController(DesignService designService) {
        this.designService = designService;
    }
    @PostMapping("design")
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
    @GetMapping("design")
    public ResponseEntity<?> getDesignDetails() {
        try {
            List<Design> designList = designService.getDesignDetails();
            responseEntity = new ResponseEntity<>(designList, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error try save after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @DeleteMapping("design/{designId}")
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
    @GetMapping("design/{designCode}")
    public ResponseEntity<?> getAllDesign(@PathVariable int designCode) {
        try {
            responseEntity = new ResponseEntity(designService.getAllDesign(designCode), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error try save after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @PutMapping("design/{designId}")
    public ResponseEntity<?> updateDesign(@RequestBody Design design, @PathVariable("designId") String designId) {
        return new ResponseEntity<>(designService.updateDesign(design, designId), HttpStatus.OK);
    }

}
