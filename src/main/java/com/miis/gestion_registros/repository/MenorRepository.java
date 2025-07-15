package com.miis.gestion_registros.repository;

import com.miis.gestion_registros.model.Menor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Indica que es un componente de repositorio de Spring
public interface MenorRepository extends JpaRepository<Menor, String> {
    // JpaRepository ya proporciona métodos básicos como save(), findById(),
    // findAll(), deleteById()

    // Spring Data JPA puede crear consultas automáticamente si sigues la convención
    // de nombres
    Optional<Menor> findByDni(String dni);
}
