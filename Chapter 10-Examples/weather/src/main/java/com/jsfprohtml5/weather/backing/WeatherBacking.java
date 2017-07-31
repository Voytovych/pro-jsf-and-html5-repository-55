package com.jsfprohtml5.weather.backing;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class WeatherBacking extends BaseBacking {
    public String logout() {      
        getSession().invalidate();
        
        return "/home.xhtml?faces-redirect=true";
    }
}