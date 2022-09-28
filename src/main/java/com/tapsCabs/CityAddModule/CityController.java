package com.tapsCabs.CityAddModule;

import com.tapsCabs.DTO.OperationalCity;
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
 * @implNote controller for crud operations of operational cities
 */
@RestController
class CityController implements ICityController {

  private static final Logger log = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private ICityService cityService;


    /**
     *
     * @param city
     * @return
     */
   @Override
      public ResponseEntity<String> addCity(OperationalCity city){
       log.info("admin requested the addcity api");
        return new ResponseEntity<>(cityService.addCity(city), HttpStatus.OK);
      }

    /**
     *
     * @return
     */
    @Override
      public ResponseEntity<List<OperationalCity>> getCities(){
       log.info("admin requested the api for fetching the city");
         return new ResponseEntity<>(cityService.getCities(),HttpStatus.OK);
      }
}
