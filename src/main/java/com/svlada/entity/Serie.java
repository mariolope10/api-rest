package com.svlada.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mario.lope
 */
@Entity
@Table(name = "serie")
public class Serie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pais_id")
    private Pais pais;
    
    @Column(name = "fecha_desde")
    private Integer fecha_desde;
    
    @Column(name = "fecha_hasta")
    private Integer fecha_hasta;

    @OneToMany(
            mappedBy = "serie",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    //@OrderBy("valor ASC")
    private List<SerieAno> monedas_ano = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
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

    public List<SerieAno> getMonedas_ano() {
        return monedas_ano;
    }

    public void setMonedas_ano(List<SerieAno> monedas_ano) {
        this.monedas_ano = monedas_ano;
    }

}
