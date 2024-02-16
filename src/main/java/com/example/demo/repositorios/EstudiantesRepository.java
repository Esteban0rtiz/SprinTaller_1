package com.example.demo.repositorios;

import com.example.demo.entidades.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiantesRepository extends JpaRepository<Estudiantes, Integer> {
}
