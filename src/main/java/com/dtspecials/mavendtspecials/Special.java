/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtspecials.mavendtspecials;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Eduardo
 */
@Entity
@Table(name = "SPECIALS", catalog = "", schema = "DTSPECIALS")
@NamedQueries({
    @NamedQuery(name = "Special.findAll", query = "SELECT s FROM Special s"),
    @NamedQuery(name = "Special.findBySname", query = "SELECT s FROM Special s WHERE s.sname = :sname"),
    @NamedQuery(name = "Special.findBySdate", query = "SELECT s FROM Special s WHERE s.sdate = :sdate"),
    @NamedQuery(name = "Special.findByStime", query = "SELECT s FROM Special s WHERE s.stime = :stime"),
    @NamedQuery(name = "Special.findByStime2", query = "SELECT s FROM Special s WHERE s.stime2 = :stime2"),
    @NamedQuery(name = "Special.findByStype", query = "SELECT s FROM Special s WHERE s.stype = :stype"),
    @NamedQuery(name = "Special.findByDescription", query = "SELECT s FROM Special s WHERE s.description = :description"),
    @NamedQuery(name = "Special.findById", query = "SELECT s FROM Special s WHERE s.id = :id")})
public class Special implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "SNAME")
    private String sname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SDATE")
    @Temporal(TemporalType.DATE)
    private Date sdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STIME2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stime2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STYPE")
    private String stype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "BUSS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Business bussId;

    public Special() {
    }

    public Special(Integer id) {
        this.id = id;
    }

    public Special(Integer id, Date sdate, Date stime, Date stime2, String stype, String description) {
        this.id = id;
        this.sdate = sdate;
        this.stime = stime;
        this.stime2 = stime2;
        this.stype = stype;
        this.description = description;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Date getStime2() {
        return stime2;
    }

    public void setStime2(Date stime2) {
        this.stime2 = stime2;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Special)) {
            return false;
        }
        Special other = (Special) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dtspecials.mavendtspecials.Special[ id=" + id + " ]";
    }
    
}
