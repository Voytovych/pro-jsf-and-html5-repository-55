package com.jsfprohtml5.weather.backing;
import static com.jsfprohtml5.weather.backing.BaseBacking.SYSTEM_ERROR;
import com.jsfprohtml5.weather.model.AppUser;
import com.jsfprohtml5.weather.model.UserManagerLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.servlet.ServletException;

@Named
@RequestScoped
public class WeatherBacking extends BaseBacking {
    
    @EJB
    private UserManagerLocal userManager;        
    
    @PostConstruct
    public void loadUser(ComponentSystemEvent event) {        
        try {
            String userID = getRequest().getUserPrincipal().getName();
            AppUser sourceAppUser = userManager.getUser(userID);
            AppUser targetAppUser = (AppUser) evaluateEL("#{appUser}", AppUser.class);
            
            targetAppUser.setFirstName(sourceAppUser.getFirstName());
            targetAppUser.setLastName(sourceAppUser.getLastName());
            targetAppUser.setZipCode(sourceAppUser.getZipCode());
        } catch (Exception ex) {
            Logger.getLogger(WeatherBacking.class.getName()).log(Level.SEVERE, null, ex);
            getContext().addMessage(null, new FacesMessage(SYSTEM_ERROR));         
        }        
    }
    
    public String logout() {      
        try {
            getRequest().logout();
            
            return "/home.xhtml?faces-redirect=true";
        } catch (ServletException ex) {
            Logger.getLogger(WeatherBacking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}