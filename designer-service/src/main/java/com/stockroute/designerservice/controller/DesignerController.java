package com.stockroute.designerservice.controller;
import com.stockroute.designerservice.exception.DesignerAlreadyExitsException;
import com.stockroute.designerservice.exception.DesignerNotFoundException;
import com.stockroute.designerservice.model.DesignerEntity;
import com.stockroute.designerservice.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class DesignerController {
    @Autowired
    private DesignerService designerService;
    private ResponseEntity responseEntity;

    @PostMapping("/addDesigner")
    public ResponseEntity createDesignerProfile(@RequestBody DesignerEntity designerEntity)  throws DesignerAlreadyExitsException{
        try {
            designerService.saveDesigner(designerEntity);
            responseEntity = new ResponseEntity<>(designerEntity, HttpStatus.CREATED);
        } catch (DesignerAlreadyExitsException e) {
            throw new DesignerAlreadyExitsException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error try save after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @GetMapping ("/AllUDesigners")
    public ResponseEntity<?> getAllDesignerDetails() {
        return new ResponseEntity<>(designerService.getAllDesigners(), HttpStatus.OK);
    }

    @GetMapping("/findByDesignerId/{designerId}")
    public ResponseEntity<?> getUserByDesignerId(@PathVariable String designerId) {
        return new ResponseEntity<>(designerService.findDesignersByDesignerId(designerId), HttpStatus.OK);
    }
    @GetMapping("/findByEmailId/{emailId}")
    public ResponseEntity<?> getUserByEmailId(@PathVariable String emailId) {
        return new ResponseEntity<>(designerService.findDesignersByEmailId(emailId), HttpStatus.OK);
    }

    @DeleteMapping("/deletebyDesignerId/{designerId}")
    public ResponseEntity<?> deleteUser(@PathVariable("designerId") String designerId)throws DesignerNotFoundException{
        try {
            designerService.deleteDesignerById(designerId);
            responseEntity = new ResponseEntity<>("Successfully deleted!!!!", HttpStatus.OK);
        } catch (DesignerNotFoundException e) {
            throw new DesignerNotFoundException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }



    @DeleteMapping("/clearAllHistory")
    public ResponseEntity<String> clearOrderHistory(){
        return new ResponseEntity<>(designerService.deleteAllOrders(), HttpStatus.OK);
    }



}
