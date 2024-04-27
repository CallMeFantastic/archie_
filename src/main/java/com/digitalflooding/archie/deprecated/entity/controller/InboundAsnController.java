package com.digitalflooding.archie.deprecated.entity.controller;

/*import com.digitalflooding.archie.deprecated.entity.service.InboundAsnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class InboundAsnController {

    @Autowired
    private InboundAsnService service;

    @Autowired
    private InboundAsnService positionService;

    @Autowired
    private InboundAsnPositionController positionController;

    @GetMapping("/InboundAsn")
    public List<InboundAsn> getAsns(){
        return service.getInboundAsns();
    }

    @PostMapping("/InboundAsn/addNew")
    public InboundAsn addAsn(@RequestBody InboundAsn inboundAsn){
        return service.addInboundAsn(inboundAsn);
    }

    @PostMapping("/InboundAsn/addAll")
    public ResponseEntity<?> addAllInboundAsns(@RequestBody List<InboundAsn> inboundAsnList) {
        List<InboundAsn> savedAsns = new ArrayList<>();

        for (InboundAsn inboundAsn : inboundAsnList) {
            // Save InboundAsn
            InboundAsn savedAsn = service.addInboundAsn(inboundAsn);
            savedAsns.add(savedAsn);

            // Save InboundAsnPositions
            //if (inboundAsn.getPositions() != null && !inboundAsn.getPositions().isEmpty()) {
            //    for (InboundAsnPosition position : inboundAsn.getPositions()) {
            //        // Set the InboundAsn reference
            //        position.setDocument(savedAsn);
//
            //        // Save the InboundAsnPosition after saving InboundAsn
            //        positionService.addInboundAsnPosition(position);
            //    }
            //}
        }

        return new ResponseEntity<>(savedAsns, HttpStatus.CREATED);
    }


    @PutMapping("/InboundAsn/edit/{id}")
    public void updateAsn(@RequestBody InboundAsn inboundAsn){
        service.updateInboundAsn(inboundAsn);
    }

    @DeleteMapping("/InboundAsn/delete/{id}")
    public void deleteAsn(@PathVariable("id") Long id){
        service.deleteInboundAsn(id);
    }

    /**
     * Deletes all the position related to a given InboundAsn
     * @param id of the given InboundAsn
    @DeleteMapping("/InboundAsn/InboundAsnPosition/delete/{id}")
    public void deleteAllAsnPositions(@PathVariable("id") Long id){
        positionService.deleteInboundAsnPosition(id);
    }
}*/
