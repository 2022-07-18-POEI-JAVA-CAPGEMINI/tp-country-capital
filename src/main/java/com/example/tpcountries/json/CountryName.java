package com.example.tpcountries.json;

public class CountryName {

    private String common;
    private String official;

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    @Override
    public String toString() {
        return "CountryName{" +
                "common='" + common + '\'' +
                ", official='" + official + '\'' +
                '}';
    }
}
