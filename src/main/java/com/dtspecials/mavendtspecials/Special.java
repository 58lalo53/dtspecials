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
 * @author root
 */
@Entity
@Table(name = "SPECIALS", catalog = "dtspecials", schema = "")
@NamedQueries({
    @NamedQuery(name = "Special.findAll", query = "SELECT s FROM Special s"),
    @NamedQuery(name = "Special.findByName", query = "SELECT s FROM Special s WHERE s.name = :name"),
    @NamedQuery(name = "Special.findByDate", query = "SELECT s FROM Special s WHERE s.date = :date"),
    @NamedQuery(name = "Special.findByDescription", query = "SELECT s FROM Special s WHERE s.description = :description"),
    @NamedQuery(name = "Special.findById", query = "SELECT s FROM Special s WHERE s.id = :id")})
public class Special implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "BUSS_ID", referencedColumnName = "ID")
    @ManyToOne
    private Business bussId;
    private static final long serialVersionUID = 1L;
    

    public Special() {
    }

    public Special(Integer id) {
        this.id = id;
    }

    public Special(Integer id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
