package com.jsfprohtml5.megaapp.service.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author Hazem Saleh <hazems@apache.org>
 */
@ApplicationException(rollback=true)
public class BookNotFound extends Exception {
    public BookNotFound () {
        this.message = "Book not found";
    }
    
    public BookNotFound(String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return this.message; 
    }
    
    private String message;
}
