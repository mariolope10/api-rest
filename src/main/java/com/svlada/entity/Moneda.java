package com.svlada.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name = "moneda")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        resolver = EntityIdResolver.class,
        scope = Moneda.class)
@FilterDef(name = "filterByUserId",
        parameters = @ParamDef(name = "id", type = "long"))
public class Moneda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "fecha_emision")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_emision;

    @Column(name = "km")
    private String km;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ceca_id")
    private Ceca ceca;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "valor_id")
    private Valor valor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tematica_id")
    private Tematica tematica;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serie_ano_id")
    @JsonIgnore
    private SerieAno serie_ano;

    @OneToMany(mappedBy = "moneda")
    @Filter(name = "filterByUserId", condition = "user_id = :id")
    private Set<UserMoneda> user_monedas = new HashSet<UserMoneda>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;

    @Column(name = "tirada_unc")
    private Integer tirada_unc;

    @Column(name = "tirada_bu")
    private Integer tirada_bu;

    @Column(name = "tirada_proof")
    private Integer tirada_proof;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Ceca getCeca() {
        return ceca;
    }

    public void setCeca(Ceca ceca) {
        this.ceca = ceca;
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    public SerieAno getSerie_ano() {
        return serie_ano;
    }

    public void setSerie_ano(SerieAno serie_ano) {
        this.serie_ano = serie_ano;
    }

    public Set<UserMoneda> getUser_monedas() {
        return user_monedas;
    }

    public void setUser_monedas(Set<UserMoneda> user_monedas) {
        this.user_monedas = user_monedas;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Integer getTirada_unc() {
        return tirada_unc;
    }

    public void setTirada_unc(Integer tirada_unc) {
        this.tirada_unc = tirada_unc;
    }

    public Integer getTirada_bu() {
        return tirada_bu;
    }

    public void setTirada_bu(Integer tirada_bu) {
        this.tirada_bu = tirada_bu;
    }

    public Integer getTirada_proof() {
        return tirada_proof;
    }

    public void setTirada_proof(Integer tirada_proof) {
        this.tirada_proof = tirada_proof;
    }

    @Override
    public String toString() {
        return "Moneda{" + "id=" + id + ", ano=" + ano + ", fecha_emision=" + fecha_emision + ", km=" + km + ", motivo=" + motivo + ", autor=" + autor + ", imagen=" + imagen + ", comentario=" + comentario + ", pais=" + pais + ", ceca=" + ceca + ", valor=" + valor + ", tematica=" + tematica + ", tipo=" + tipo + ", tirada_unc=" + tirada_unc + ", tirada_bu=" + tirada_bu + ", tirada_proof=" + tirada_proof + '}';
    }

}
