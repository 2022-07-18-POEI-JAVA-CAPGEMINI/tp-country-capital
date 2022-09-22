package com.example.tpcountries;

import com.example.tpcountries.business.Question;
import com.example.tpcountries.dao.Country;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuizUnitTests {

    @Test
    void testPlay() {
        Question question = new Question();

        Country country1 = new Country();
        country1.setName("France");
        country1.setCapital("Paris");
        Country country2 = new Country();
        country2.setName("Espagne");
        country2.setCapital("Madrid");
        Country country3 = new Country();
        country3.setName("Italie");
        country3.setCapital("Rome");
        Country country4 = new Country();
        country4.setName("Portugal");
        country4.setCapital("Lisbonne");

        Country[] countries = new Country[4];
        countries[0] = country1;
        countries[1] = country2;
        countries[2] = country3;
        countries[3] = country4;
        question.setSelectedCountries(countries);

        question.setCorrectAnswer(country2);

        assertFalse(question.play("Paris"));
        assertTrue(question.play("Madrid"));
    }

}
