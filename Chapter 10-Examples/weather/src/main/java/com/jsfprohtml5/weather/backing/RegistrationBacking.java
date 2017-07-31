package com.jsfprohtml5.weather.backing;

import com.jsfprohtml5.weather.model.AppUser;
import com.jsfprohtml5.weather.model.UserExistsException;
import com.jsfprohtml5.weather.model.UserManagerLocal;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class RegistrationBacking extends BaseBacking {
    
    @EJB
    private UserManagerLocal userManager;    
    
    public String register() { 
        FacesContext context = FacesContext.getCurrentInstance();
        Map<Object, Object> flowScope = context.getApplication().getFlowHandler().getCurrentFlowScope();
        
        AppUser appUser = new AppUser();
        
        appUser.setId((String) flowScope.get("id"));
        appUser.setPassword((String) flowScope.get("password"));
        appUser.setEmail((String) flowScope.get("email"));
        
        appUser.setFirstName((String) flowScope.get("fname"));
        appUser.setLastName((String) flowScope.get("lname"));
        appUser.setProfession((String) flowScope.get("profession"));        
        
        appUser.setZipCode((String) flowScope.get("zipCode"));
        
        try {
            userManager.registerUser(appUser);
        } catch (UserExistsException ex) {
            Logger.getLogger(RegistrationBacking.class.getName()).log(Level.SEVERE, null, ex);
            context.addMessage(null, new FacesMessage(USERNAME_ALREADY_EXISTS));
            return null;
        } catch (Exception ex) {
            Logger.getLogger(RegistrationBacking.class.getName()).log(Level.SEVERE, null, ex);
            context.addMessage(null, new FacesMessage(SYSTEM_ERROR));
            return null;            
        }
        
        return "flowReturn";
    }
    
    private static final String USERNAME_ALREADY_EXISTS = "Username already exists ...";
}