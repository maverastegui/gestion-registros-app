package com.miis.gestion_registros.service;

import com.miis.gestion_registros.model.Menor;
import com.miis.gestion_registros.repository.MenorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service // Indica que es un componente de servicio de Spring
public class MenorService {

    @Autowired // Inyecta la dependencia del repositorio
    private MenorRepository menorRepository;

    public Menor guardarMenor(Menor menor) {
        // Opcional: Puedes añadir lógica de negocio adicional aquí antes de guardar
        if (menorRepository.existsById(menor.getDni())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El DNI ya existe en la base de datos.");
        }
        return menorRepository.save(menor);
    }

    public Menor consultarMenorPorDni(String dni) {
        // findById devuelve un Optional, que manejamos para el caso de no encontrado
        return menorRepository.findById(dni)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Menor con DNI " + dni + " no encontrado."));
    }
}