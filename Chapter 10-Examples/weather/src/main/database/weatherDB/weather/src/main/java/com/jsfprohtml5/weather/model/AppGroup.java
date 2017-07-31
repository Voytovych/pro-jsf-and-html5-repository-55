/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfprohtml5.weather.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "APP_GROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppGroup.findAll", query = "SELECT a FROM AppGroup a")})
public class AppGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AppGroupPK appGroupPK;
    @JoinColumn(name = "USERID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AppUser appUser;

    public AppGroup() {
    }

    public AppGroup(AppGroupPK appGroupPK) {
        this.appGroupPK = appGroupPK;
    }

    public AppGroup(String userid, String groupid) {
        this.appGroupPK = new AppGroupPK(userid, groupid);
    }

    public AppGroupPK getAppGroupPK() {
        return appGroupPK;
    }

    public void setAppGroupPK(AppGroupPK appGroupPK) {
        this.appGroupPK = appGroupPK;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appGroupPK != null ? appGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppGroup)) {
            return false;
        }
        AppGroup other = (AppGroup) object;
        if ((this.appGroupPK == null && other.appGroupPK != null) || (this.appGroupPK != null && !this.appGroupPK.equals(other.appGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsfprohtml5.weather.model.AppGroup[ appGroupPK=" + appGroupPK + " ]";
    }
    
}
