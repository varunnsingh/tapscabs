package com.tapsCabs.cabAddAndExploreModule;

import com.tapsCabs.DTO.CabCategory;
import com.tapsCabs.DTO.Taxi;
import com.tapsCabs.pojos.Cab;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote  controller interface for CRUD operations of Cab
 */
@RequestMapping("/cab")
 interface ICabController {
   /**
    *
    * @param cab
    * @return
    */
    @PostMapping("/add")
    ResponseEntity<String> addCab(@RequestBody Taxi cab);

   /**
    *
    * @param city
    * @return
    */
    @GetMapping("/get/{city}")
    ResponseEntity<List<Taxi>> getAllCabs(@PathVariable String city);

   /**
    *
    * @param cabCategory
    * @return
    */
    @PostMapping("/taxifare")
    ResponseEntity<String> addTaxiFare(@RequestBody CabCategory cabCategory);

   /**
    *
    * @param cabId
    * @return
    */
    @DeleteMapping("/delete/{cabId}")
    ResponseEntity<String> deleteCab(@PathVariable int cabId);
}
