package com.tapsCabs.cabAddAndExploreModule;

import com.tapsCabs.DTO.CabCategory;
import com.tapsCabs.DTO.CabExploreModel;
import com.tapsCabs.pojos.TaxiFare;

import java.io.IOException;
import java.util.List;


 interface IExploreCabService {


    List<CabCategory> exploreCabOneWay(String fromS,String toS) throws IOException, InterruptedException;



     List<CabCategory> exploreCabLocal(String city);



     List<CabCategory> exploreCabRoundTrip(String fromS,String toS) throws IOException, InterruptedException;
 }
