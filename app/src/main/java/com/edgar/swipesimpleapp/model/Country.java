package com.edgar.swipesimpleapp.model;


public class Country {

    private String country;
    private String population;

    public Country(String country, String population) {
        this.country = country;
        this.population = population;
    }

    public String getCountry() {
        return country;
    }

    public String getPopulation() {
        return population;
    }

}
