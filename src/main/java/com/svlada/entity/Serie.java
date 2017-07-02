package com.svlada.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "serie")
public class Serie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "pais")
    private String pais;
    
    @Column(name = "fecha_desde")
    private Integer fecha_desde;
    
    @Column(name = "fecha_hasta")
    private Integer fecha_hasta;

    @OneToMany(
            mappedBy = "serie",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderBy("valor ASC")
    private List<MonedaComun> monedas = new ArrayList<>();
    
    @OneToMany(
            mappedBy = "serie",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Tirada> tiradas = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(Integer fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public Integer getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(Integer fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    public List<MonedaComun> getMonedas() {
        return monedas;
    }

    public void setMonedas(List<MonedaComun> monedas) {
        this.monedas = monedas;
    }

    public List<Tirada> getTiradas() {
        return tiradas;
    }

    public void setTiradas(List<Tirada> tiradas) {
        this.tiradas = tiradas;
    }

}
