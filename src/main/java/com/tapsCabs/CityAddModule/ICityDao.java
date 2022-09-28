package com.tapsCabs.CityAddModule;

import com.tapsCabs.pojos.City;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote Repository for operational cities
 */
public interface ICityDao extends JpaRepository<City,Integer> {
    City findByCityName(String fromCity);
}
