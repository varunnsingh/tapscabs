package com.tapsCabs.cabAddAndExploreModule;


import com.tapsCabs.DTO.CabCategory;
import com.tapsCabs.pojos.TaxiFare;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @apiNote service layer for exploring the cab fare between two cities
 */

@Service
  class ExploreCabService implements IExploreCabService {

    final static Logger log = LoggerFactory.getLogger(ExploreCabService.class);
    private HttpClient client = HttpClient.newBuilder().build();
    @Autowired
    private ITaxiFareDao taxiFareDao;

    private int driverComp =1;
    private int gst = 5;


    /**
     * @apiNote explores cab fare and travel details for one way
     * @param fromS
     * @param toS
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public List<CabCategory> exploreCabOneWay(String fromS,String toS) throws IOException, InterruptedException {
       log.info("exploring one way cab in service");
        List<TaxiFare> taxiList = taxiFareDao.findAll();
        List<CabCategory> cabCategories = new ArrayList<>();
      String  fromCoordinates = findCoordinates(fromS);
      String toCoordinates= findCoordinates(toS);
       String[] distanceAndTime = findDistance(fromCoordinates,toCoordinates);//distance between cities is on index 0
        String distance = distanceAndTime[0].replace("km","").trim();
        float distanceInNumber = Float.parseFloat(distance);
        for(TaxiFare t: taxiList){
            CabCategory cabCategory = new CabCategory();
          float price = distanceInNumber *t.getPrice()*(100+driverComp+gst)/100;
            cabCategory.setPrice(price);
            cabCategory.setCarCategory(t.getCarCategory());
            cabCategory.setSampleCarName(t.getSampleCarName());
            cabCategory.setDistance(distanceAndTime[0]);
            cabCategory.setDuration(distanceAndTime[1]);
            cabCategories.add(cabCategory);
        }
        return cabCategories;
    }

    /**
     * @apiNote explores cab fare and travel details for local
     * @param city
     * @return
     */
    @Override
    public List<CabCategory> exploreCabLocal(String city) {
        log.info("exploring local cab in service");
        List<TaxiFare> taxiList = taxiFareDao.findAll();
        List<CabCategory> cabCategories = new ArrayList<>();
        for(TaxiFare t:taxiList){
            CabCategory cabCategory = new CabCategory();
            cabCategory.setPrice(t.getPrice());
            cabCategory.setCarCategory(t.getCarCategory());
            cabCategory.setSampleCarName(t.getSampleCarName());

            cabCategories.add(cabCategory);
        }
        return cabCategories;
    }

    /**
     * @apiNote explores cab fare and travel details for round trip
     * @param fromS
     * @param toS
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public List<CabCategory> exploreCabRoundTrip(String fromS,String toS) throws IOException, InterruptedException {
        log.info("exploring round trip cab in service");
        List<TaxiFare> taxiList = taxiFareDao.findAll();
        List<CabCategory> cabCategories = new ArrayList<>();
        String  fromCoordinates = findCoordinates(fromS);
        String toCoordinates= findCoordinates(toS);
        String[] distanceAndTime = findDistance(fromCoordinates,toCoordinates);
        String distance = distanceAndTime[0].replace("km","").trim();
        float distanceInNumber = Float.parseFloat(distance);
        for(TaxiFare t: taxiList){
            CabCategory cabCategory = new CabCategory();
            float price = 2*distanceInNumber*t.getPrice()*(100+driverComp+gst)/100;
            cabCategory.setPrice(price);
            cabCategory.setCarCategory(t.getCarCategory());
            cabCategory.setSampleCarName(t.getSampleCarName());
            cabCategory.setDistance(distanceAndTime[0]);
            cabCategory.setDuration(distanceAndTime[1]);
            cabCategories.add(cabCategory);
        }
        return cabCategories;
    }

    /**
     * @implNote finds coordinates of city selected
     * @param place
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    private String findCoordinates(String place) throws IOException, InterruptedException {
        log.info("requesting the third party api for coordinates");
        place = place.replace(" ","+");
        place = place.replace(",","+");
        place = place.replace(", ","+");
        String url1 = "https://api.radar.io/v1/geocode/forward?query="+place;
        var request1=  HttpRequest.newBuilder().GET().uri(URI.create(url1))
                .header("Authorization", "prj_live_pk_0529dbd31dfd5ccf26104eaacfe2bd2d175cc07c")
                .build();
        var responseCode = client.send(request1,HttpResponse.BodyHandlers.ofString()).body();
        JSONObject geoCode = new JSONObject(responseCode);
        JSONArray address =  geoCode.getJSONArray("addresses");
        JSONObject obj1 = (JSONObject) address.get(0);
        String latitude = obj1.get("latitude").toString();
        String longitude =obj1.get("longitude").toString();
        return latitude.concat(",").concat(longitude);

    }


    /**
     * @implNote finds the distance between two cities provided by requesting a 3rd party api
     * @param from
     * @param to
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    private String[] findDistance(String from, String to) throws IOException, InterruptedException {
       log.info("requesting the third party api for finding distance");
        String [] arr = new String[2] ;
        String url = "https://api.radar.io/v1/route/distance?origin="+from+"&destination="+to+"&modes=car&units=metric";
      var request=  HttpRequest.newBuilder().GET().uri(URI.create(url))
              .header("Authorization", "prj_live_pk_0529dbd31dfd5ccf26104eaacfe2bd2d175cc07c")
              .build();
      var response = client.send(request,HttpResponse.BodyHandlers.ofString()).body();
      System.out.println(response);
        JSONObject obj = new JSONObject(response);
        JSONObject rt = (JSONObject) obj.get("routes");
        JSONObject cr =  (JSONObject) rt.get("car");
        JSONObject dist =(JSONObject) cr.get("distance");
        JSONObject dur = (JSONObject) cr.get("duration");

        arr[0] = (String) dist.get("text");
        arr[1] = (String) dur.get("text");
        
        return arr;
    }
    }


