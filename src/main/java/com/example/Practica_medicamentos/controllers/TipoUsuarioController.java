package com.example.Practica_medicamentos.controllers;

import com.example.Practica_medicamentos.models.TipoUsuario;
import com.example.Practica_medicamentos.repositories.TipoUsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class TipoUsuarioController {

    private final Logger log = Logger.getLogger(TipoUsuarioController.class.getName());

    private TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioController(TipoUsuarioRepository _tipoUsuarioRepository) {
        tipoUsuarioRepository = _tipoUsuarioRepository;
    }

    //Crud basico
    //buscar todos
    @GetMapping("api/tipo-usuario")
    public List<TipoUsuario> findAll() {
        if (tipoUsuarioRepository.findAll().isEmpty()) {
            return new ArrayList<>();
        };
        return tipoUsuarioRepository.findAll();
    }

    //buscar por id
    @GetMapping("api/tipo-usuario/{id}")
    public ResponseEntity<TipoUsuario> findById( @PathVariable long id) {
        Optional<TipoUsuario> tipoUsuario = tipoUsuarioRepository.findById(id);
        return tipoUsuario.isPresent() ? ResponseEntity.ok(tipoUsuario.get()) : ResponseEntity.notFound().build();
    }
    @PostMapping("api/tipo-usuario")
    public ResponseEntity<String> create(@RequestBody TipoUsuario tipoUsuario) {
        if (tipoUsuario.getId() !=null) {
            log.warning("No se esperaba recibir un ID en el metodo");
            return ResponseEntity.badRequest().build();
        }
        tipoUsuarioRepository.save(tipoUsuario);
        return ResponseEntity.ok("tipo de usuario registrado");
    }
    @PutMapping("api/tipo-usuario")
    public ResponseEntity<String> update(@RequestBody TipoUsuario tipoUsuario) {
        if (tipoUsuarioRepository.existsById(tipoUsuario.getId())) {
            tipoUsuarioRepository.save(tipoUsuario);
            return ResponseEntity.ok("tipo de usuario actualizado");
        }
        else {
            log.warning("No se esperaba el ID en el metodo");
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("api/tipo-usuario/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        if (tipoUsuarioRepository.existsById(id)) {
            tipoUsuarioRepository.deleteById(id);
            return ResponseEntity.ok("tipo de usuario eliminado");
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

}
