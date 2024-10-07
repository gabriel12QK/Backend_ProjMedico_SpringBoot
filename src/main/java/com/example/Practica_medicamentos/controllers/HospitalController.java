package com.example.Practica_medicamentos.controllers;

import com.example.Practica_medicamentos.models.Hospital;
import com.example.Practica_medicamentos.repositories.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class HospitalController {
    private final Logger log = Logger.getLogger(HospitalController.class.getName());
    private HospitalRepository hospitalRepository;
    public HospitalController(HospitalRepository _hospitalRepository) {
        hospitalRepository = _hospitalRepository;
    }

    @GetMapping("api/hospital")
    public List<Hospital> finAll() {
        if (hospitalRepository.findAll().isEmpty()) {
            log.info("No hospital found");
            return new ArrayList<>();
        }
        return  hospitalRepository.findAll();
    }

    @GetMapping("api/hospital/{id}")
    public ResponseEntity<Hospital> findById(@PathVariable Long id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        return hospital.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(hospital.get());
    }

    @PostMapping("api/hospital")
    public ResponseEntity<String> save(@RequestBody Hospital hospital) {
        if (hospitalRepository.existsById(hospital.getId())) {
            return ResponseEntity.badRequest().body("No se esperaba un id en el metodo");
        }
        hospitalRepository.save(hospital);
        return ResponseEntity.ok("Hospital creado correctamente");
    }
    @PutMapping("api/hospital")
    public ResponseEntity<String> update(@RequestBody Hospital hospital) {
        if (hospitalRepository.existsById(hospital.getId())) {
            hospitalRepository.save(hospital);
            return ResponseEntity.ok("Hospital actualizado correctamente");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("api/hospital")
    public ResponseEntity<String> delete(@RequestBody Hospital hospital) {
        if (hospitalRepository.existsById(hospital.getId())) {
            hospitalRepository.deleteById(hospital.getId());
            return ResponseEntity.ok("Hospital eliminado correctamente");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
