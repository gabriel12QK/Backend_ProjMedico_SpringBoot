package com.example.Practica_medicamentos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="tipo_usuario")
public class tipo_usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Boolean estado;
    @OneToMany(mappedBy = "idTipoUsuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<usuario> usuarios;

    public tipo_usuario() {}

    public tipo_usuario(Long id, String nombre, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
