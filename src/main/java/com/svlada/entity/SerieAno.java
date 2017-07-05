package com.svlada.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "serie_ano")
public class SerieAno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serie_id")
    @JsonBackReference
    private Serie serie;
    
    @Column(name = "ano")
    private Integer ano;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "1c_id")
    private Moneda m1c;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "2c_id")
    private Moneda m2c;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "5c_id")
    private Moneda m5c;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "10c_id")
    private Moneda m10c;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "20c_id")
    private Moneda m20c;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "50c_id")
    private Moneda m50c;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "1e_id")
    private Moneda m1e;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "2e_id")
    private Moneda m2e;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Moneda getM1c() {
        return m1c;
    }

    public void setM1c(Moneda m1c) {
        this.m1c = m1c;
    }

    public Moneda getM2c() {
        return m2c;
    }

    public void setM2c(Moneda m2c) {
        this.m2c = m2c;
    }

    public Moneda getM5c() {
        return m5c;
    }

    public void setM5c(Moneda m5c) {
        this.m5c = m5c;
    }

    public Moneda getM10c() {
        return m10c;
    }

    public void setM10c(Moneda m10c) {
        this.m10c = m10c;
    }

    public Moneda getM20c() {
        return m20c;
    }

    public void setM20c(Moneda m20c) {
        this.m20c = m20c;
    }

    public Moneda getM50c() {
        return m50c;
    }

    public void setM50c(Moneda m50c) {
        this.m50c = m50c;
    }

    public Moneda getM1e() {
        return m1e;
    }

    public void setM1e(Moneda m1e) {
        this.m1e = m1e;
    }

    public Moneda getM2e() {
        return m2e;
    }

    public void setM2e(Moneda m2e) {
        this.m2e = m2e;
    }
    
    
}
