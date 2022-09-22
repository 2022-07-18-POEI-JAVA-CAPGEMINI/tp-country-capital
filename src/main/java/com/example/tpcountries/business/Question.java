package com.example.tpcountries.business;

import com.example.tpcountries.dao.Country;

public class Question {

    private Country[] selectedCountries = new Country[4];
    private Country correctAnswer;

    public Country[] getSelectedCountries() {
        return selectedCountries;
    }

    public void setSelectedCountries(Country[] selectedCountries) {
        this.selectedCountries = selectedCountries;
    }

    public Country getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Country correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean play(String capitalName){
        return capitalName.equals(correctAnswer.getCapital());
    }
}
