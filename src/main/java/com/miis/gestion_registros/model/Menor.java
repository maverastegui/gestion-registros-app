package com.miis.gestion_registros.model;

import jakarta.persistence.*; // Usa jakarta.persistence para Spring Boot 3+
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data // Genera getters, setters, toString, equals y hashCode con Lombok
@NoArgsConstructor // Genera un constructor sin argumentos con Lombok
@AllArgsConstructor // Genera un constructor con todos los argumentos con Lombok
@Entity // Indica que es una entidad JPA
@Table(name = "menores") // Mapea a la tabla "menores" en la base de datos
public class Menor {

    @Id // Marca el campo como clave primaria
    @Column(name = "dni", length = 12, nullable = false)
    private String dni;

    @Column(name = "nombres", length = 32, nullable = false)
    private String nombres;

    @Column(name = "apellido_paterno", length = 32, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 32, nullable = false)
    private String apellidoMaterno;

    @Column(name = "fecha_de_nacimiento", nullable = false)
    private LocalDate fechaDeNacimiento; // Tipo LocalDate para campos DATE

    @Column(name = "dep_de_nacimiento", length = 32, nullable = false)
    private String depDeNacimiento;

    // Si no usas Lombok, tendrías que generar manualmente:
    // - Getters y Setters para cada campo
    // - Constructores (vacío y con todos los campos)
    // - Métodos toString(), equals() y hashCode()
}
