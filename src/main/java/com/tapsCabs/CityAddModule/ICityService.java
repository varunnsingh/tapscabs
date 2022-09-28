package com.tapsCabs.CityAddModule;

import com.tapsCabs.DTO.OperationalCity;
import com.tapsCabs.pojos.City;

import java.util.List;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote service interface for crud operations of operational cities
 */
interface ICityService {
    String addCity(OperationalCity city);


    List<OperationalCity> getCities();
}
