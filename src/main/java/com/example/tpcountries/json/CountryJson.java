package com.example.tpcountries.json;

import java.util.Arrays;

public class CountryJson {
    private String[] capital;
    private CountryName name;
    public String[] getCapital() {
        return capital;
    }

    public void setCapital(String[] capital) {
        this.capital = capital;
    }

    public CountryName getName() {
        return name;
    }

    public void setName(CountryName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CountryJson{" +
                "capital=" + Arrays.toString(capital) +
                ", name=" + name +
                '}';
    }
}
