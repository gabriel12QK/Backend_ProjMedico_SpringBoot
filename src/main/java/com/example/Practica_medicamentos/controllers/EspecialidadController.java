package com.example.Practica_medicamentos.controllers;


import com.example.Practica_medicamentos.models.Especialidad;
import com.example.Practica_medicamentos.repositories.EspecialidadRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class EspecialidadController {
     private Logger log = Logger.getLogger(EspecialidadController.class.getName());
     private EspecialidadRepository especialidadRepository;
     public EspecialidadController(EspecialidadRepository _especialidadRepository) {
         especialidadRepository = _especialidadRepository;
     }

     //Crud
    @GetMapping("api/especialidad")
    public List<Especialidad> findAll(){
         if(especialidadRepository.findAll().isEmpty()){
             return new ArrayList<Especialidad>();
         };
         return especialidadRepository.findAll();
    }

    @GetMapping("api/especialidad/{id}")
    public ResponseEntity<Especialidad> findById(@PathVariable long id){
         Optional<Especialidad> especialidad = especialidadRepository.findById(id);
         return especialidad.isPresent() ? ResponseEntity.ok(especialidad.get()) : ResponseEntity.notFound().build();
    }
    @PostMapping("api/especialidad")
    public ResponseEntity<String> save(@RequestBody Especialidad especialidad){
        if (especialidad.getId() !=null) {
            log.warning("No se esperaba recibir un ID en el metodo");
            return ResponseEntity.badRequest().build();
        }
        especialidadRepository.save(especialidad);
        return ResponseEntity.ok("Especialidad registrada con exito");

    }
    @PutMapping("api/especialidad")
    public ResponseEntity<String> update(@RequestBody Especialidad especialidad){
         if(especialidadRepository.existsById(especialidad.getId())){
             especialidadRepository.save(especialidad);
             return ResponseEntity.ok("Especialidad actualizada con exito");

        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("api/especialidad/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
         if(especialidadRepository.existsById(id)){
             especialidadRepository.deleteById(id);
             return ResponseEntity.ok("Especialidad eliminada con exito");
         }
         else {
             return ResponseEntity.badRequest().build();
         }
    }

}
