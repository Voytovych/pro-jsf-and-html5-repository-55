package com.jsfprohtml5.weather.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserManager implements UserManagerLocal {
    
    @PersistenceContext(unitName = "weatherUnit")
    EntityManager em;    

    @Override
    public AppUser getUser(String userID) {
        Query query = em.createQuery("select appUser from AppUser appUser where "
                    + "appUser.id = :id");
        
        query.setParameter("id", userID);

        List<AppUser> result = query.getResultList();

        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        
        return null;
    }

    @Override
    public void registerUser(AppUser appUser) throws UserExistsException {
        Query query = em.createQuery("select appUser from AppUser appUser where "
                    + "appUser.id = :id");
        
        query.setParameter("id", appUser.getId());

        List<AppUser> result = query.getResultList();

        if (result != null && result.size() > 0) {
            throw new UserExistsException();
        }
        
        em.persist(appUser);
    }
}