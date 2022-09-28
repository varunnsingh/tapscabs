package com.tapsCabs.cabAddAndExploreModule;


import com.tapsCabs.DTO.CabCategory;
import com.tapsCabs.DTO.Taxi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote  controller for CRUD operations of Cab
 */
@RestController
class CabController implements  ICabController{
    static final Logger log = LoggerFactory.getLogger(CabController.class);
    @Autowired
   private ICabService cabService;

    /**
     *
     * @param cab
     * @return
     */

  public  ResponseEntity<String> addCab( Taxi cab){
      log.info("hitting the api adding the cab");
       return new ResponseEntity<>(cabService.addCab(cab), HttpStatus.OK);
    }

    /**
     *
     * @param city
     * @return
     */

    public ResponseEntity<List<Taxi>> getAllCabs(String city){
        log.info("hitting the api for fetching the cab");
        return new ResponseEntity<>(cabService.getAllCabs(city),HttpStatus.OK);
    }

    /**
     *
     * @param cabCategory
     * @return
     */

   public ResponseEntity<String> addTaxiFare(CabCategory cabCategory){
       log.info("hitting the api for adding the cab category");
       return new ResponseEntity<>(cabService.addTaxiFare(cabCategory),HttpStatus.OK);
    }

    /**
     *
     * @param cabId
     * @return
     */

    public ResponseEntity<String> deleteCab( int cabId){
        log.info("hitting the api for deleting the cab { }",cabId);
      return new ResponseEntity<>(cabService.deleteCab(cabId),HttpStatus.OK);
    }



}
