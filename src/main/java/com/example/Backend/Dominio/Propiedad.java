package com.example.Backend.Dominio;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Data
@Entity
@Table(name="propiedad")
public class Propiedad {


    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPropiedad;
    @NotEmpty
    private String tipo;
    @NotEmpty
    private String medidas;
    @NotEmpty
    private String antiguedad;
    @NotEmpty
    private String amueblado;
    @NotEmpty
    private String artefactos;
    @NotEmpty
    private String servicios;
    @NotEmpty
    private String estado = "Disponible";
    @NotEmpty
    private String monto;
    @NotEmpty
    private String propietario;
    @NotEmpty
    private String ubicacion;

    public Propiedad() { }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Long idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getAmueblado() {
        return amueblado;
    }

    public void setAmueblado(String amueblado) {
        this.amueblado = amueblado;
    }

    public String getArtefactos() {
        return artefactos;
    }

    public void setArtefactos(String artefactos) {
        this.artefactos = artefactos;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {this.estado = estado; }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }
}
