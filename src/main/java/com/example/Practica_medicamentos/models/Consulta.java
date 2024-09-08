package com.example.Practica_medicamentos.models;

import jakarta.persistence.*;


import java.time.LocalDate;
@Entity
@Table(name = "consultas")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaConsulta;
    private String diagnostico;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Usuario paciente;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Usuario medico;
    @ManyToOne
    @JoinColumn(name = "hospital")
    private Hospital hospital;
    private Boolean estado;

    public Consulta() {}

    public Consulta(Long id, LocalDate fechaConsulta, String diagnostico, Usuario medico, Hospital hospital, Boolean estado) {
        this.id = id;
        this.fechaConsulta = fechaConsulta;
        this.diagnostico = diagnostico;
        this.medico = medico;
        this.hospital = hospital;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Usuario getMedico() {
        return medico;
    }

    public void setMedico(Usuario medico) {
        this.medico = medico;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
