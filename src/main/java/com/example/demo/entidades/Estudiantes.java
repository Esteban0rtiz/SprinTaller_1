package com.example.demo.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Estudiantes {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String apellido;
    private String curso;

    /*
    @OneToOne
    @JoinColumn(name= "editorial_id")
    private Editorial editorial;

     */

}
