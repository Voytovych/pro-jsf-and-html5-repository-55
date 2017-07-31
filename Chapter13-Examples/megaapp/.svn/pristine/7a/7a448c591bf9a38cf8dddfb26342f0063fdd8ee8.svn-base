package com.jsfprohtml5.megaapp.service;

import com.jsfprohtml5.megaapp.model.Book;
import com.jsfprohtml5.megaapp.service.exception.BookAlreadyExists;
import com.jsfprohtml5.megaapp.service.exception.BookNotFound;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hazem Saleh <hazems@apache.org>
 */
@Local
public interface BookManagerLocal {   
    public Book getBookInformation(Integer bookID) throws BookNotFound;    
    public Book registerBook(Book book) throws BookAlreadyExists;    
    public Book updateBook(Book book) throws BookNotFound;    
    public void removeBook(Integer bookID) throws BookNotFound;    
    public byte[] getBookContent(Integer bookID) throws BookNotFound;
    public List<Book> getAllBooks(Book book);    
}
