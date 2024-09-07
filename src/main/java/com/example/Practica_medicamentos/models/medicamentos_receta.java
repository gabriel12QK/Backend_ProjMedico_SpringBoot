package com.example.Practica_medicamentos.models;

import jakarta.persistence.*;

@Entity
@Table(name="medicamentos_receta")
public class medicamentos_receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "receta_id")
    private receta receta;
    @ManyToOne
    @JoinColumn(name = "medicamentos_id")
    private medicamentos idMedicamento;

}
