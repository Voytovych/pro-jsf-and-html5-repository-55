package com.jsfprohtml5.megaapp.service.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author Hazem Saleh <hazems@apache.org>
 */
@ApplicationException(rollback=true)
public class BookRequestNotFound extends Exception {
    public BookRequestNotFound () {
        this.message = "Book request not found";
    }
    
    public BookRequestNotFound(String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return this.message; 
    }
    
    private String message;
}
