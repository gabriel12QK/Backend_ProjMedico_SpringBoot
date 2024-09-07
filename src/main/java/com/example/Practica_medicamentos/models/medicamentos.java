package com.example.Practica_medicamentos.models;

import jakarta.persistence.*;

@Entity
@Table(name="medicamentos")
public class medicamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String laboratorio;
    private int peso;
    private Boolean estado;
    public medicamentos() {}
    public medicamentos(Long id, String nombre, String laboratorio, int peso,Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.peso = peso;
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

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
