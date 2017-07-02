package com.svlada.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tirada")
public class Tirada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "ano")
    private Integer ano;
    
    @Column(name = "1c")
    private Integer tirada1c;
    
    @Column(name = "2c")
    private Integer tirada2c;
    
    @Column(name = "5c")
    private Integer tirada5c;
    
    @Column(name = "10c")
    private Integer tirada10c;
    
    @Column(name = "20c")
    private Integer tirada20c;
    
    @Column(name = "50c")
    private Integer tirada50c;
    
    @Column(name = "1e")
    private Integer tirada1e;
    
    @Column(name = "2e")
    private Integer tirada2e;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serie_id")
    @JsonBackReference
    private Serie serie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getTirada1c() {
        return tirada1c;
    }

    public void setTirada1c(Integer tirada1c) {
        this.tirada1c = tirada1c;
    }

    public Integer getTirada2c() {
        return tirada2c;
    }

    public void setTirada2c(Integer tirada2c) {
        this.tirada2c = tirada2c;
    }

    public Integer getTirada5c() {
        return tirada5c;
    }

    public void setTirada5c(Integer tirada5c) {
        this.tirada5c = tirada5c;
    }

    public Integer getTirada10c() {
        return tirada10c;
    }

    public void setTirada10c(Integer tirada10c) {
        this.tirada10c = tirada10c;
    }

    public Integer getTirada20c() {
        return tirada20c;
    }

    public void setTirada20c(Integer tirada20c) {
        this.tirada20c = tirada20c;
    }

    public Integer getTirada50c() {
        return tirada50c;
    }

    public void setTirada50c(Integer tirada50c) {
        this.tirada50c = tirada50c;
    }

    public Integer getTirada1e() {
        return tirada1e;
    }

    public void setTirada1e(Integer tirada1e) {
        this.tirada1e = tirada1e;
    }

    public Integer getTirada2e() {
        return tirada2e;
    }

    public void setTirada2e(Integer tirada2e) {
        this.tirada2e = tirada2e;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

}
