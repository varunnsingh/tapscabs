package com.tapsCabs.CityAddModule;

import com.tapsCabs.DTO.OperationalCity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote controller interface for crud operations of operational cities
 */
@RequestMapping("/city")
 interface ICityController {



    @PostMapping("/add")
    ResponseEntity<String> addCity(@RequestBody OperationalCity city);

    @GetMapping("/get")
    ResponseEntity<List<OperationalCity>> getCities();
}
