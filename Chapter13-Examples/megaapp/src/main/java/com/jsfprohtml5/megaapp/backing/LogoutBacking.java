package com.jsfprohtml5.megaapp.backing;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.ServletException;

/**
 *
 * @author Hazem Saleh <hazems@apache.org>
 */

@Named
@RequestScoped
public class LogoutBacking extends BaseBacking {
    
    public String logout() {      
        try {
            getRequest().logout();
            
            return "/login.xhtml?faces-redirect=true";
        } catch (ServletException ex) {
            Logger.getLogger(LogoutBacking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}