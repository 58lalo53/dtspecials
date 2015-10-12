/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtspecials.mavendtspecials;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Eduardo
 */
@Entity
@Table(name = "BUSSPROFILES", catalog = "", schema = "DTSPECIALS")
@NamedQueries({
    @NamedQuery(name = "Bussprofile.findAll", query = "SELECT b FROM Bussprofile b"),
    @NamedQuery(name = "Bussprofile.findByBname", query = "SELECT b FROM Bussprofile b WHERE b.bname = :bname"),
    @NamedQuery(name = "Bussprofile.findByBtype", query = "SELECT b FROM Bussprofile b WHERE b.btype = :btype"),
    @NamedQuery(name = "Bussprofile.findByDescription", query = "SELECT b FROM Bussprofile b WHERE b.description = :description"),
    @NamedQuery(name = "Bussprofile.findByPhone", query = "SELECT b FROM Bussprofile b WHERE b.phone = :phone"),
    @NamedQuery(name = "Bussprofile.findByStreet", query = "SELECT b FROM Bussprofile b WHERE b.street = :street"),
    @NamedQuery(name = "Bussprofile.findByCity", query = "SELECT b FROM Bussprofile b WHERE b.city = :city"),
    @NamedQuery(name = "Bussprofile.findByBstate", query = "SELECT b FROM Bussprofile b WHERE b.bstate = :bstate"),
    @NamedQuery(name = "Bussprofile.findByZip", query = "SELECT b FROM Bussprofile b WHERE b.zip = :zip"),
    @NamedQuery(name = "Bussprofile.findByWebsite", query = "SELECT b FROM Bussprofile b WHERE b.website = :website"),
    @NamedQuery(name = "Bussprofile.findByPictype", query = "SELECT b FROM Bussprofile b WHERE b.pictype = :pictype"),
    @NamedQuery(name = "Bussprofile.findById", query = "SELECT b FROM Bussprofile b WHERE b.id = :id")})
public class Bussprofile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BNAME")
    private String bname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "BTYPE")
    private String btype;
    @Size(max = 1000)
    @Column(name = "DESCRIPTION")
    private String description;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PHONE")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STREET")
    private String street;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "BSTATE")
    private String bstate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "ZIP")
    private String zip;
    @Size(max = 100)
    @Column(name = "WEBSITE")
    private String website;
    @Lob
    @Column(name = "PICTURE")
    private Serializable picture;
    @Size(max = 30)
    @Column(name = "PICTYPE")
    private String pictype;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "BUSS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Business bussId;

    public Bussprofile() {
    }

    public Bussprofile(Integer id) {
        this.id = id;
    }

    public Bussprofile(Integer id, String bname, String btype, String phone, String street, String city, String bstate, String zip) {
        this.id = id;
        this.bname = bname;
        this.btype = btype;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.bstate = bstate;
        this.zip = zip;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBstate() {
        return bstate;
    }

    public void setBstate(String bstate) {
        this.bstate = bstate;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Serializable getPicture() {
        return picture;
    }

    public void setPicture(Serializable picture) {
        this.picture = picture;
    }

    public String getPictype() {
        return pictype;
    }

    public void setPictype(String pictype) {
        this.pictype = pictype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Business getBussId() {
        return bussId;
    }

    public void setBussId(Business bussId) {
        this.bussId = bussId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bussprofile)) {
            return false;
        }
        Bussprofile other = (Bussprofile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dtspecials.mavendtspecials.Bussprofile[ id=" + id + " ]";
    }
    
}
