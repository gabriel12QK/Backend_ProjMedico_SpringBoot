package com.example.Practica_medicamentos.controllers;

import com.example.Practica_medicamentos.models.Consulta;
import com.example.Practica_medicamentos.repositories.ConsultaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultaController {
    //ets variable se usara para mapear errores y donde se ocasionaron
    private final Logger log = LoggerFactory.getLogger(ConsultaController.class);

    private ConsultaRepository consultaRepository;

    public ConsultaController(ConsultaRepository _consultaRepository) {
        this.consultaRepository= _consultaRepository;
    }

    //Crud para la entidad


}

