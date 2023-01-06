package com.stockroute.designerservice.designer.controller;
import com.stockroute.designerservice.designer.exception.IdNotFound;
import com.stockroute.designerservice.designer.exception.ProfileAlreadyExit;
import com.stockroute.designerservice.designer.model.Designer;
import com.stockroute.designerservice.designer.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/designerService")
public class DesignerController {


    private DesignerService designerService;
    @Autowired
    public DesignerController(DesignerService designerService) {
        this.designerService = designerService;
    }

    @PostMapping("/addDesigner")
    public ResponseEntity<Designer> createDesignerProfile(@RequestBody Designer designer) throws ProfileAlreadyExit {
         designerService.saveDesigner(designer);
        return new ResponseEntity<>(designer,HttpStatus.CREATED);
    }

    @GetMapping("/AllUDesigners")
    public ResponseEntity<List<Designer>> getAllDesignerDetails() {
        List<Designer> designerList=designerService.getAllDesigners();
        return new ResponseEntity<>(designerList, HttpStatus.OK);
    }

    @GetMapping("/findByEmailId/{EmailId}")
    public ResponseEntity<List<Designer>> getdesignerByEmailId(@PathVariable String EmailId) {
        List<Designer> designerListByEmail=designerService.findDesignersByEmailId(EmailId);
        return new ResponseEntity<>(designerListByEmail, HttpStatus.OK);
    }

    @DeleteMapping("/deletebyDesignerId/{designerId}")
    public ResponseEntity<Boolean> deleteDesigner(@PathVariable("designerId") String designerId) throws IdNotFound {
        Boolean isDeleted=designerService.deleteDesignerByDesignerId(designerId);
        return new ResponseEntity<>(isDeleted, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/clearAllHistory")
    public ResponseEntity<String> clearOrderHistory(){
        String responseString=designerService.deleteAllOrders();
        return new ResponseEntity<>(responseString,HttpStatus.OK);
    }
    @GetMapping("/findByDesignerId/{DesignerId}")
    public ResponseEntity<Designer> getDesignerByDesignerId(@PathVariable String DesignerId) throws IdNotFound {
        Designer designer=designerService.findDesignerByDesignerId(DesignerId);
        return new ResponseEntity<>(designer, HttpStatus.OK);
    }
}
