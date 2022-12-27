package com.stockroute.designerservice.designer.controller;
import com.stockroute.designerservice.designer.exception.ProfileAlreadyExit;
import com.stockroute.designerservice.designer.model.Designer;
import com.stockroute.designerservice.designer.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v11")
public class DesignerController {


    private DesignerService designerService;
    @Autowired
    public DesignerController(DesignerService designerService) {
        this.designerService = designerService;
    }

    @PostMapping("/addDesigner")
    public Designer createDesignerProfile(@RequestBody Designer designer) throws ProfileAlreadyExit {
        return designerService.saveDesigner(designer);
    }

    @GetMapping("/AllUDesigners")
    public ResponseEntity<?> getAllDesignerDetails() {
        return new ResponseEntity<>(designerService.getAllDesigners(), HttpStatus.OK);
    }

    @GetMapping("/findByEmailId/{EmailId}")
    public ResponseEntity<?> getdesignerByEmailId(@PathVariable String EmailId) {
        return new ResponseEntity<>(designerService.findDesignersByEmailId(EmailId), HttpStatus.OK);
    }

    @DeleteMapping("/deletebyEmail/{designerId}")
    public ResponseEntity<?> deleteUser(@PathVariable("designerId") String designerId){
        return new ResponseEntity<>(designerService.deleteDesignerById(designerId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/clearAllHistory")
    public ResponseEntity<String> clearOrderHistory(){
        return new ResponseEntity<>(designerService.deleteAllOrders(),HttpStatus.OK);
    }

}
