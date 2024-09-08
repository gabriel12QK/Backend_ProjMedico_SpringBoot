package com.example.Practica_medicamentos.models;

import jakarta.persistence.*;

@Entity
@Table(name="medicamentos_receta")
public class MedicamentosReceta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "receta_id")
    private Receta receta;
    @ManyToOne
    @JoinColumn(name = "medicamentos_id")
    private Medicamentos idMedicamento;
    private String dosis;

    public MedicamentosReceta() {}
    public MedicamentosReceta(Long id, Receta receta, Medicamentos idMedicamento, String dosis) {
        this.id = id;
        this.receta = receta;
        this.idMedicamento = idMedicamento;
        this.dosis = dosis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Medicamentos getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Medicamentos idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
}
