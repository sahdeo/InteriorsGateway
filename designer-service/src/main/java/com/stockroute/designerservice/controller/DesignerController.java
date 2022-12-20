package com.stockroute.designerservice.controller;

import com.stockroute.designerservice.model.DesignerEntity;
import com.stockroute.designerservice.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class DesignerController {
    @Autowired
    private DesignerService designerService;

    @PostMapping("/addDesigner")
    public DesignerEntity createDesignerProfile(@RequestBody DesignerEntity designerEntity)  {
        return designerService.saveDesigner(designerEntity);
    }

    @GetMapping ("/AllUDesigners")
    public ResponseEntity<?> getAllDesignerDetails() {
        return new ResponseEntity<>(designerService.getAllDesigners(), HttpStatus.OK);
    }

    @GetMapping("/findByEmailId/{EmailId}")
    public ResponseEntity<?> getUserByEmailId(@PathVariable String designerId) {
        return new ResponseEntity<>(designerService.findDesignersByDesignerId(designerId), HttpStatus.OK);
    }

    @DeleteMapping("/deletebyEmail/{designerId}")
    public ResponseEntity<?> deleteUser(@PathVariable("designerId") String designerId){
        return new ResponseEntity<>(designerService.deleteDesignerById(designerId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/clearAllHistory")
    public ResponseEntity<String> clearOrderHistory(){
        return new ResponseEntity<>(designerService.deleteAllOrders(), HttpStatus.OK);
    }



}
