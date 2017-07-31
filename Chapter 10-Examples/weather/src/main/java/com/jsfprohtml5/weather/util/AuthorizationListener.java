package com.jsfprohtml5.weather.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AuthorizationListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();
        NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
        
        String currentPage = context.getViewRoot().getViewId();
 
        boolean isProtectedPage = currentPage.contains("/protected/");

        //Restrict access to protected pages ...
        if (isProtectedPage) {
            navigationHandler.handleNavigation(context, null, "/home?faces-redirect=true");
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
