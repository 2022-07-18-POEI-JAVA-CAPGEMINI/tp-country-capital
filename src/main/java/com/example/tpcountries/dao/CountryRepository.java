package com.example.tpcountries.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query( value="SELECT * FROM countries ORDER BY RAND() LIMIT 4"
            , nativeQuery = true)
    public Country[] getRandomCountries();
}