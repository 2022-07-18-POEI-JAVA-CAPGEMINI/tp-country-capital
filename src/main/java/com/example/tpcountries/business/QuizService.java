package com.example.tpcountries.business;

import com.example.tpcountries.dao.Country;
import com.example.tpcountries.dao.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    CountryRepository countryRepository;

    public Question getNewQuestion() {
        Question question = new Question();
        //List<Country> countries = countryRepository.getRandomCountries();
        Country[] countries = countryRepository.getRandomCountries();
        question.setSelectedCountries(countries);
        Random random = new Random();
        int index = random.nextInt(4);
        question.setCorrectAnswer(countries[index]);

        return question;
    }


}
