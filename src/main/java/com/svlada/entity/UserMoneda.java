package com.svlada.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_moneda", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "moneda_id"})
})
public class UserMoneda implements Serializable {

    private static final long serialVersionUID = 1L;

    public UserMoneda() {
    }

    public UserMoneda(User user, Moneda moneda) {
        this.user = user;
        this.moneda = moneda;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", updatable = false)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = User.class)
    @JsonIdentityReference(alwaysAsId = true)
    private User user;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "moneda_id", updatable = false)
    @JsonIdentityReference(alwaysAsId = true)
    private Moneda moneda;

    @Column(name = "circ_coleccion")
    private Integer circ_coleccion = 0;

    @Column(name = "circ_intercambio")
    private Integer circ_intercambio = 0;

    @Column(name = "sc_coleccion")
    private Integer sc_coleccion = 0;

    @Column(name = "sc_intercambio")
    private Integer sc_intercambio = 0;

    @Column(name = "bu_coleccion")
    private Integer bu_coleccion = 0;

    @Column(name = "bu_intercambio")
    private Integer bu_intercambio = 0;

    @Column(name = "proof_coleccion")
    private Integer proof_coleccion = 0;

    @Column(name = "proof_intercambio")
    private Integer proof_intercambio = 0;

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

    @Override
    public String toString() {
        return "UserMoneda{" + "id=" + id + ", user=" + user + ", moneda=" + moneda + ", circ_coleccion=" + circ_coleccion + ", circ_intercambio=" + circ_intercambio + ", sc_coleccion=" + sc_coleccion + ", sc_intercambio=" + sc_intercambio + ", bu_coleccion=" + bu_coleccion + ", bu_intercambio=" + bu_intercambio + ", proof_coleccion=" + proof_coleccion + ", proof_intercambio=" + proof_intercambio + '}';
    }
}
