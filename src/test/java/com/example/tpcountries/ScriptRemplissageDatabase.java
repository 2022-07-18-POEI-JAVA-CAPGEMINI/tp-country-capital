package com.example.tpcountries;

import com.example.tpcountries.dao.Country;
import com.example.tpcountries.dao.CountryRepository;
import com.example.tpcountries.json.CountryJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@SpringBootTest
class ScriptRemplissageDatabase {

    @Autowired
    CountryRepository countryRepository;
    @Autowired
    private WebClient.Builder webClientBuilder;
    String url = "https://restcountries.com/v3.1/region/europe";

    // ATTENTION : ici on modifie la base de données !!!
    //@Test
    void getCountriesObject() {

       List<CountryJson> countries = webClientBuilder.build()
                .get() // verb GET HTTTP
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CountryJson>>() {})
                .block();

        for(CountryJson json : countries){
            Country entity = new Country();
            entity.setName(json.getName().getCommon());
            entity.setCapital(json.getCapital()[0]);
            countryRepository.save(entity);
        }
    }

}
