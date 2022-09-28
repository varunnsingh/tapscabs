package com.tapsCabs.cabAddAndExploreModule;


import com.tapsCabs.DTO.CabCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote  controller for exploring the cab fairs between two cities
 */
@RestController
class ExploreCabController implements  IExploreCabController{

    final static Logger log = LoggerFactory.getLogger(ExploreCabController.class);
    @Autowired
    private IExploreCabService exploreCabService;

    /**
     *
     * @param fromC
     * @param toC
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
   public ResponseEntity<List<CabCategory>> exploreCabOneWay(String fromC,String toC) throws IOException, InterruptedException {
      log.info("user has requested one way cab");
       return  new ResponseEntity<>(exploreCabService.exploreCabOneWay(fromC,toC), HttpStatus.OK);

    }

    /**
     *
     * @param city
     * @return
     */

   public ResponseEntity<List<CabCategory>> exploreCabLocal(String city)  {
       log.info("user has requested local cab");
        return  new ResponseEntity<>(exploreCabService.exploreCabLocal(city),HttpStatus.OK);

    }

    /**
     *
     * @param fromC
     * @param toC
     * @return
     * @throws IOException
     * @throws InterruptedException
     */

    public ResponseEntity<List<CabCategory>> exploreCabRoundTrip(String fromC,String toC) throws IOException, InterruptedException {
        log.info("user has requested inter-state cab");
        return new ResponseEntity<>(exploreCabService.exploreCabRoundTrip(fromC,toC),HttpStatus.OK);
    }


}
