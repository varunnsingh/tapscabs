package com.tapsCabs.CityAddModule;


import com.tapsCabs.DTO.OperationalCity;
import com.tapsCabs.pojos.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote service layer for crud operations of operational cities
 */
@Service
class CityService implements ICityService {

    final static Logger log = LoggerFactory.getLogger(CityService.class);
    @Autowired
    private ICityDao cityDao;

    /**
     * @apiNote  for autopopulating listOfCities is used
     */
    private List<OperationalCity> listOfCities = new ArrayList<>();

    /**
     *
     * @param city
     * @return
     */
    @Override
    public String addCity(OperationalCity city) {
        log.info("adding the city in service");
        if(city==null){
            log.warn("city details sent are null");
        }
        City cty = new City();
        cty.setCityName(city.getCityName());
        cty.setState(city.getState());
        cty.setStateCode(city.getStateCode());
        cityDao.save(cty);
        listOfCities.add(city);
            return "City added successfully";

    }

    /**
     *
     * @return
     */
    @Override
    public List<OperationalCity> getCities() {
        log.info("fetching the cities in service");
        if(listOfCities.isEmpty()) {
            List<City> list = cityDao.findAll();
            for(City city: list){
                OperationalCity oCity = new OperationalCity();
                oCity.setCityName(city.getCityName());
                oCity.setState(city.getState());
                oCity.setStateCode(city.getStateCode());
                listOfCities.add(oCity);
            }
            return listOfCities;
        }else {
            return listOfCities;
        }
    }
}
