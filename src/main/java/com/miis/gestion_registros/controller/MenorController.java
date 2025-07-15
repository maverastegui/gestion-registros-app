package com.miis.gestion_registros.controller;

import com.miis.gestion_registros.model.Menor;
import com.miis.gestion_registros.service.MenorService;
import jakarta.validation.Valid; // Para validación de campos
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Indica que es un controlador REST
@RequestMapping("/api/v1/registros") // Prefijo para todos los endpoints en este controlador
public class MenorController {

    @Autowired // Inyecta la dependencia del servicio
    private MenorService menorService;

    // Endpoint 1: Grabar un nuevo registro en la tabla "menores"
    // POST http://localhost:8080/api/v1/registros
    @PostMapping
    public ResponseEntity<Menor> grabarMenor(@Valid @RequestBody Menor menor) {
        Menor nuevoMenor = menorService.guardarMenor(menor);
        return new ResponseEntity<>(nuevoMenor, HttpStatus.CREATED);
    }

    // Endpoint 2: Consulta registro por dni
    // GET http://localhost:8080/api/v1/registros/{dni}
    @GetMapping("/{dni}")
    public ResponseEntity<Menor> consultarMenorPorDni(@PathVariable String dni) {
        Menor menor = menorService.consultarMenorPorDni(dni);
        return new ResponseEntity<>(menor, HttpStatus.OK);
    }

}
