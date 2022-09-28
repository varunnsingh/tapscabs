package com.tapsCabs.cabAddAndExploreModule;

import com.tapsCabs.pojos.Cab;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Varun Singh
 * @version 1.0
 * @implNote Cab saving repository
 */
interface ICabDao extends JpaRepository<Cab,Integer> {

    List<Cab> findAllByCity(String city);
}
