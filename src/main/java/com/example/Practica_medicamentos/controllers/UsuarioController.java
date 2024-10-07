package com.example.Practica_medicamentos.controllers;

import com.example.Practica_medicamentos.models.Usuario;
import com.example.Practica_medicamentos.repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class UsuarioController {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository _usuarioRepository){
        usuarioRepository = _usuarioRepository;
    }

    @GetMapping("api/usuario")
     public List<Usuario> findAll(){
        if(usuarioRepository.findAll().isEmpty()){
            log.info("La tabla Usuarios esta vacia");
            return new ArrayList<>() ;
        }
        return usuarioRepository.findAll();
    }

    @GetMapping("api/usuario/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.isEmpty() ? ResponseEntity.notFound().build():ResponseEntity.ok(usuario.get());
    }

    @PostMapping("api/usuario")
    public ResponseEntity<String> save(@RequestBody Usuario usuario){
        if(usuarioRepository.existsById(usuario.getId())){
            log.info("no se esperaba un ID en el metodo");
            return ResponseEntity.badRequest().build();
        }
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("usuario creado correctamente");
    }
    @PutMapping("api/usuario")
    public ResponseEntity<String> update(@RequestBody Usuario usuario){
        if(usuarioRepository.existsById(usuario.getId())){
            usuarioRepository.save(usuario);
            return ResponseEntity.ok("usuario actualizado correctamente");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("api/usuario/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok("usuario eliminado correctamente");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
