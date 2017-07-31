package com.jsfprohtml5.megaapp.service;

import com.jsfprohtml5.megaapp.model.MegaUser;
import com.jsfprohtml5.megaapp.service.exception.UserAlreadyExists;
import com.jsfprohtml5.megaapp.service.exception.UserNotFound;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hazem Saleh <hazems@apache.org>
 */
@Local
public interface MegaUserManagerLocal {
    public MegaUser getMegaUser(String userID) throws UserNotFound;
    public List<MegaUser> retrieveMegaUsers();        
    public MegaUser registerMegaUser(MegaUser user) throws UserAlreadyExists;
    public void removeMegaUser(String userID) throws UserNotFound;    
}
