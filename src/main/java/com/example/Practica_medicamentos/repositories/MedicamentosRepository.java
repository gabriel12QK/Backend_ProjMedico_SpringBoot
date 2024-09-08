package com.example.Practica_medicamentos.repositories;

import com.example.Practica_medicamentos.models.Medicamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentosRepository extends JpaRepository<Medicamentos,Long> {
}
