package com.example.demo.repositorios;

import com.example.demo.entidades.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesoresRepository extends JpaRepository<Profesores, Integer> {

}
