package com.example.Backend.Dominio;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name="propietario")
public class Propietario implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPropietario;
    @NotEmpty
    private String nombres;
    @NotEmpty
    private String apellidos;
    @NotEmpty
    private String dni;
    @NotEmpty
    private String email;
    @NotEmpty
    private String telefono;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Propietario() {
    }

    public Long getIdPropiedario() {
        return idPropietario;
    }

    public void setIdPropiedario(Long idPropiedario) {
        this.idPropietario = idPropiedario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
