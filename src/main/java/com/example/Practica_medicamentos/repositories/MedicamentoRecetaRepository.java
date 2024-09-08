package com.example.Practica_medicamentos.repositories;

import com.example.Practica_medicamentos.models.MedicamentosReceta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRecetaRepository extends JpaRepository<MedicamentosReceta, Long > {
}
