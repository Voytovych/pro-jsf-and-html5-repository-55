package com.jsfprohtml5.weather.backing;

import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class BaseBacking {
    
    protected FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }
    
    protected Map getRequestMap() {
        return getContext().getExternalContext().getRequestMap();
    }
    
    protected HttpSession getSession() {
        return (HttpSession) getContext().getExternalContext().getSession(false);
    }
  
    protected Object evaluateEL(String elExpression, Class beanClazz) {
        return getContext().getApplication().evaluateExpressionGet(getContext(), elExpression, beanClazz);
    }
    
    public static final String SYSTEM_ERROR = "System error ...";
}
