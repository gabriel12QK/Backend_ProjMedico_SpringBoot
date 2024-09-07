package com.example.Practica_medicamentos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="especialidad")
public class especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Boolean estado;
    @OneToMany(mappedBy = "idEspecialidad", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<usuario> usuarios;
    public especialidad() {}
    public especialidad(Long id, String nombre, Boolean estado) {
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
