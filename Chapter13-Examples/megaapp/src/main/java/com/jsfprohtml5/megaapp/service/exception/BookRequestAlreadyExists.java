package com.jsfprohtml5.megaapp.service.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author Hazem Saleh <hazems@apache.org>
 */
@ApplicationException(rollback=true)
public class BookRequestAlreadyExists extends Exception {
    public BookRequestAlreadyExists () {
        this.message = "Book request already exists";
    }
    
    public BookRequestAlreadyExists(String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return this.message; 
    }
    
    private String message;
}
