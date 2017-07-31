package com.jsfprohtml5.weather.backing;

import com.jsfprohtml5.weather.model.AppUser;
import com.jsfprohtml5.weather.model.UserManagerLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBacking extends BaseBacking {
    private static final String INVALID_USERNAME_OR_PASSWORD = "Invalid Username or password";
    
    @EJB
    private UserManagerLocal userManager;    
    
    
    public String login() {
        AppUser currentAppUser = (AppUser) evaluateEL("#{appUser}", AppUser.class);
         
        try {
            AppUser appUser = userManager.getUser(currentAppUser.getId(), currentAppUser.getPassword()); 
                        
            if (appUser == null) {
                getContext().addMessage(null, new FacesMessage(INVALID_USERNAME_OR_PASSWORD));
                return null;
            }
            
            //Set Necessary user information
            currentAppUser.setEmail(appUser.getEmail());
            currentAppUser.setFirstName(appUser.getFirstName());
            currentAppUser.setLastName(appUser.getLastName());
            currentAppUser.setZipCode(appUser.getZipCode());
            currentAppUser.setProfession(appUser.getProfession());
        } catch (Exception ex) {
            Logger.getLogger(LoginBacking.class.getName()).log(Level.SEVERE, null, ex);
            getContext().addMessage(null, new FacesMessage(SYSTEM_ERROR));
            return null;            
        }
        
        getContext().getApplication().getFlowHandler().getCurrentFlowScope();
        return "/protected/weather";        
    }
}