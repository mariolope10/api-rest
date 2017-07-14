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
@Table(name = "user_moneda")
public class UserMoneda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "moneda_id")
    @JsonBackReference
    private Moneda moneda;
    
    @Column(name = "circ_coleccion")
    private Integer circ_coleccion;
    
    @Column(name = "circ_intercambio")
    private Integer circ_intercambio;
    
    @Column(name = "sc_coleccion")
    private Integer sc_coleccion;
    
    @Column(name = "sc_intercambio")
    private Integer sc_intercambio;
    
    @Column(name = "bu_coleccion")
    private Integer bu_coleccion;
    
    @Column(name = "bu_intercambio")
    private Integer bu_intercambio;
    
    @Column(name = "proof_coleccion")
    private Integer proof_coleccion;
    
    @Column(name = "proof_intercambio")
    private Integer proof_intercambio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Integer getCirc_coleccion() {
        return circ_coleccion;
    }

    public void setCirc_coleccion(Integer circ_coleccion) {
        this.circ_coleccion = circ_coleccion;
    }

    public Integer getCirc_intercambio() {
        return circ_intercambio;
    }

    public void setCirc_intercambio(Integer circ_intercambio) {
        this.circ_intercambio = circ_intercambio;
    }

    public Integer getSc_coleccion() {
        return sc_coleccion;
    }

    public void setSc_coleccion(Integer sc_coleccion) {
        this.sc_coleccion = sc_coleccion;
    }

    public Integer getSc_intercambio() {
        return sc_intercambio;
    }

    public void setSc_intercambio(Integer sc_intercambio) {
        this.sc_intercambio = sc_intercambio;
    }

    public Integer getBu_coleccion() {
        return bu_coleccion;
    }

    public void setBu_coleccion(Integer bu_coleccion) {
        this.bu_coleccion = bu_coleccion;
    }

    public Integer getBu_intercambio() {
        return bu_intercambio;
    }

    public void setBu_intercambio(Integer bu_intercambio) {
        this.bu_intercambio = bu_intercambio;
    }

    public Integer getProof_coleccion() {
        return proof_coleccion;
    }

    public void setProof_coleccion(Integer proof_coleccion) {
        this.proof_coleccion = proof_coleccion;
    }

    public Integer getProof_intercambio() {
        return proof_intercambio;
    }

    public void setProof_intercambio(Integer proof_intercambio) {
        this.proof_intercambio = proof_intercambio;
    }

}
