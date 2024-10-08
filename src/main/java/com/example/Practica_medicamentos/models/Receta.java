package com.example.Practica_medicamentos.models;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "receta")

public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean estadoEntrega;
    private LocalDate fechaEntrega;
    @ManyToOne
    @JoinColumn(name = "consultas")
    private Consulta idConsulta;
    private Boolean estado;

    public Receta() {}

    public Receta(Long id, Boolean estadoEntrega, LocalDate fechaEntrega, Consulta idConsulta, Boolean estado) {
        this.id = id;
        this.estadoEntrega = estadoEntrega;
        this.fechaEntrega = fechaEntrega;
        this.idConsulta = idConsulta;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(Boolean estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Consulta getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Consulta idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
