package com.jsfprohtml5.weather.model;

import com.jsfprohtml5.weather.model.AppGroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-16T01:09:20")
@StaticMetamodel(AppUser.class)
public class AppUser_ { 

    public static volatile SingularAttribute<AppUser, String> id;
    public static volatile SingularAttribute<AppUser, String> lastName;
    public static volatile SingularAttribute<AppUser, String> email;
    public static volatile ListAttribute<AppUser, AppGroup> appGroupList;
    public static volatile SingularAttribute<AppUser, String> profession;
    public static volatile SingularAttribute<AppUser, String> zipCode;
    public static volatile SingularAttribute<AppUser, String> firstName;
    public static volatile SingularAttribute<AppUser, String> password;

}