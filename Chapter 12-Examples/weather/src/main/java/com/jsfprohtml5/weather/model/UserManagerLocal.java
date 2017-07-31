package com.jsfprohtml5.weather.model;

import javax.ejb.Local;

@Local
public interface UserManagerLocal {
    public AppUser getUser(String userID);
    public void registerUser(AppUser user) throws UserExistsException;
}