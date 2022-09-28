package com.tapsCabs.cabAddAndExploreModule;

import com.tapsCabs.DTO.CabCategory;
import com.tapsCabs.DTO.Taxi;
import com.tapsCabs.pojos.Cab;

import java.util.List;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote service interface for performing CRUD operations of Cab
 */
interface ICabService {

    String addCab(Taxi cab);

    List<Taxi> getAllCabs(String city);

    String addTaxiFare(CabCategory cabCategory);

    String deleteCab(int cabId);


}
