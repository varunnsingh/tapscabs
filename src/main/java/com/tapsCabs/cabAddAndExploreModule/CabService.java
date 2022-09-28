package com.tapsCabs.cabAddAndExploreModule;

import com.tapsCabs.DTO.CabCategory;
import com.tapsCabs.DTO.Taxi;
import com.tapsCabs.CityAddModule.ICityDao;
import com.tapsCabs.enums.PermitEnums;
import com.tapsCabs.exceptions.CabNotFoundException;
import com.tapsCabs.pojos.Cab;
import com.tapsCabs.pojos.TaxiFare;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote service layer for performing CRUD operations of Cab
 */
@Service
class CabService implements ICabService {
    final static Logger log = LoggerFactory.getLogger(CabService.class);

    @Autowired
    private ICabDao cabDao;
    @Autowired
    private ITaxiFareDao taxiFareDao;

    @Autowired
    private ICityDao cityDao;

    /**
     *
     * @param cab
     * @return cab saving confirmation as string
     *
     */

    @Override
    public String addCab(Taxi cab) {
        log.info(" cab is added in service ");
        if(cab==null){
            log.warn("cab details sent by admin is null");
        }
      Cab cb =new Cab();
        cb.setCabType(cab.getCabType());
        cb.setCity(cab.getCity());
        cb.setMake(cab.getMake());
        cb.setPermit(cab.getPermit());
        cb.setAlternateDriverPhoneNumber(cab.getAlternateDriverPhoneNumber());
        cb.setDriverAddress(cab.getDriverAddress());
        cb.setDriverName(cab.getDriverName());
        cb.setDriverPhoneNumber(cab.getDriverPhoneNumber());
        cb.setModel(cab.getModel());
        cb.setRegisNo(cab.getRegisNo());
        cb.setStatus(String.valueOf(PermitEnums.ACTIVE));
        Cab taxi = cabDao.save(cb);
        return "cab details uploaded";
    }

    /**
     *
     * @param city
     * @return list of Taxi DTO
     */
    @Override
    public List<Taxi> getAllCabs(String city) {
        log.info(" cab is fetching from { } ",city);
        List<Cab> cabList = cabDao.findAllByCity(city);
        cabList = cabList.stream().filter(c->c.getStatus().equals(String.valueOf(PermitEnums.ACTIVE)))
                .collect(Collectors.toList());
        List<Taxi> taxiList = new ArrayList<>();
        for(Cab c: cabList){
            Taxi t = new Taxi();
            t.setId(c.getCabId());
            t.setCabType(c.getCabType());
            t.setCity(c.getCity());
            t.setMake(c.getMake());
            t.setDriverName(c.getDriverName());
            t.setDriverAddress(c.getDriverAddress());
            t.setDriverPhoneNumber(c.getDriverPhoneNumber());
            t.setAlternateDriverPhoneNumber(c.getAlternateDriverPhoneNumber());
            t.setPermit(c.getPermit());
            t.setModel(c.getModel());
            t.setRegisNo(c.getRegisNo());
            taxiList.add(t);
        }
        return taxiList;
    }


    /**
     *
     * @param cabCategory
     * @return String message
     */
    @Override
    public String addTaxiFare(CabCategory cabCategory) {
        log.info("cab category is being added");
        if(cabCategory==null){
            log.warn("cabCategory details sent by admin is null");
        }

        TaxiFare taxiFare = new TaxiFare();
        taxiFare.setPrice(cabCategory.getPrice());
        taxiFare.setCarCategory(cabCategory.getCarCategory());
        taxiFare.setSampleCarName(cabCategory.getSampleCarName());
            taxiFareDao.save(taxiFare);
            return "Taxi Fare Added";

    }

    /**
     *
     * @param cabId
     * @return String message
     */
    @Override
    public String deleteCab(int cabId) {
         log.info("deleting the cab {}",cabId);
         String logRef = String.valueOf(cabId);
       Optional<Cab> cab =
               Optional.of(cabDao.findById(cabId))
                       .orElseThrow(()-> new CabNotFoundException("Cab with id {} does not exist",logRef));

        Cab c = cab.get();
        c.setStatus(String.valueOf(PermitEnums.INACTIVE));
        cabDao.save(c);
           return "Cab with  "+c.getRegisNo()+"is removed successfully";

    }






    }




