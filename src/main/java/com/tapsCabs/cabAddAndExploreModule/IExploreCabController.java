package com.tapsCabs.cabAddAndExploreModule;


import com.tapsCabs.DTO.CabCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote  controller interface for exploring the cab fairs between two cities
 */
@RequestMapping("/explore/cab")
interface IExploreCabController {

    @GetMapping("/oneway")
    ResponseEntity<List<CabCategory>> exploreCabOneWay(@RequestParam String from, @RequestParam String to) throws IOException, InterruptedException;


    @GetMapping("/local/{city}")
    ResponseEntity<List<CabCategory>> exploreCabLocal(@PathVariable String city);

    @GetMapping("/roundTrip")
    ResponseEntity<List<CabCategory>> exploreCabRoundTrip(@RequestParam String from, @RequestParam String to) throws IOException, InterruptedException;
}
