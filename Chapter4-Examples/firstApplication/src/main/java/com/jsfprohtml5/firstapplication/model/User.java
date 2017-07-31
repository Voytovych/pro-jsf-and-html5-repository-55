package com.jsfprohtml5.firstapplication.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class User implements Serializable {
    
    private String name;
    private String password;
    private Profession profession;
    
    private List<String> favoriteSports;
    private Map<String, String> spokenLanguages;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<String> getFavoriteSport() {
        return favoriteSports;
    }

    public void setFavoriteSports(List<String> favoriteSports) {
        this.favoriteSports = favoriteSports;
    }    
    
    public Map<String, String> getSpokenLanguages() {      
        return spokenLanguages;
    }

    public void setSpokenLanguages(Map<String, String> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }    
    
    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
    
    public String login() {      
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        
        // User passes through the login page ...
        session.setAttribute("isAuthenticated", true);
        
        return "welcome";
    }
    
    public String logout() {      
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);

        session.removeAttribute("isAuthenticated");
        
        return "index";
    }
    
    @PostConstruct
    private void initialize() {
        System.out.println("Bean is initialized with the following user name: " + name);       
    }
    
    @PreDestroy
    private void cleanUp() {
        System.out.println("You can do the cleanup here");
    }
}