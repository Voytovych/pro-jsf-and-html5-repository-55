package com.jsfprohtml5.firstapplication.model;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class AuthorizationListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();
        String currentPage = context.getViewRoot().getViewId();
 
        boolean isLoginPage = currentPage.endsWith("index.xhtml");
        
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        Object isAuthenticated = session.getAttribute("isAuthenticated");
        
        //System.out.println("isLoginPage = " + isLoginPage);

        if (!isLoginPage && isAuthenticated == null) {
            NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(context, null, "index");
            
            //System.out.println("Routing to the index page ...");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        //Nothing ...
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
