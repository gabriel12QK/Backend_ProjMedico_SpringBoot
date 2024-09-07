package com.example.Practica_medicamentos.models;

import jakarta.persistence.*;


import java.time.LocalDate;
@Entity
@Table(name = "consultas")
public class consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaConsulta;
    private String diagnostico;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private usuario paciente;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private usuario medico;
    @ManyToOne
    @JoinColumn(name = "hospital")
    private hospital hospital;
    private Boolean estado;

    public consulta() {}

    public consulta(Long id, LocalDate fechaConsulta, String diagnostico, usuario medico, com.example.Practica_medicamentos.models.hospital hospital, Boolean estado) {
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

    public usuario getMedico() {
        return medico;
    }

    public void setMedico(usuario medico) {
        this.medico = medico;
    }

    public com.example.Practica_medicamentos.models.hospital getHospital() {
        return hospital;
    }

    public void setHospital(com.example.Practica_medicamentos.models.hospital hospital) {
        this.hospital = hospital;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
