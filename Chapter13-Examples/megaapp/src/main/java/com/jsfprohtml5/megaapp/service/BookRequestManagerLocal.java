package com.jsfprohtml5.megaapp.service;

import com.jsfprohtml5.megaapp.model.BookRequest;
import com.jsfprohtml5.megaapp.service.exception.BookRequestAlreadyExists;
import com.jsfprohtml5.megaapp.service.exception.BookRequestNotFound;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hazem Saleh <hazems@apache.org>
 */
@Local
public interface BookRequestManagerLocal {
    public BookRequest sendBookRequest(BookRequest bookRequest) throws BookRequestAlreadyExists;    
    public void approveBookRequest(Integer bookRequestNumber) throws BookRequestNotFound;    
    public void rejectBookRequest(Integer bookRequestNumber) throws BookRequestNotFound;    

    public List<BookRequest> viewRequests(String userName, int status);   
}
