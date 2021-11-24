package com.example.Backend.Dominio;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idUsuario;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Rol> role;

    public User() { }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Rol> getRole() {
        return role;
    }

    public void setRole(List<Rol> role) {
        this.role = role;
    }
}
