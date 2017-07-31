package com.jsfprohtml5.weather.model;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "APP_USER")
@Named
@RequestScoped
public class AppUser implements Serializable {
    private static final long serialVersionUID = 134523456789194332L;
    
    @Id
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "ID")
    private String id;

    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PASSWORD")
    private String password;
    
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PROFESSION")
    private String profession;
    
    @NotNull
    @Size(max = 64)
    @Column(name = "EMAIL")
    private String email;
    
    @NotNull    
    @Size(max = 32)
    @Column(name = "ZIP_CODE")
    private String zipCode;    

    public AppUser() {
    }

    public AppUser(String id) {
        this.id = id;
    }

    public AppUser(String id, String firstName, String lastName, String password, String profession, String zipCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.profession = profession;
        this.zipCode = zipCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }    

    @Override
    public String toString() {
        return "ID = " + id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}