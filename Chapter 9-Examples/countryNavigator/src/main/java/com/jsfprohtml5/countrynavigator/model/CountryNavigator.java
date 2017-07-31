package com.jsfprohtml5.countrynavigator.model;

import java.util.List;

public class CountryNavigator {
    private List<Country> countries;
    private Country activeCountry;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public Country getActiveCountry() {
        return activeCountry;
    }

    public void setActiveCountry(Country activeCountry) {
        this.activeCountry = activeCountry;
    }
}
