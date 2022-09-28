package com.tapsCabs.cabAddAndExploreModule;

import com.tapsCabs.pojos.TaxiFare;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @apiNote repository for storing categories of cab available and standard fares
 */
interface ITaxiFareDao extends JpaRepository<TaxiFare,Integer> {
    TaxiFare findByCarCategory(String s);
}
