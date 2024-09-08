package com.example.Practica_medicamentos.repositories;

import com.example.Practica_medicamentos.models.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
}
