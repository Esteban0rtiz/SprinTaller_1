package com.example.demo.controladores;

import com.example.demo.entidades.Estudiantes;
import com.example.demo.repositorios.EstudiantesRepository;
import com.example.demo.entidades.Profesores;
import com.example.demo.repositorios.ProfesoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController
public class EstudiantesController {

    @Autowired
    EstudiantesRepository estudiantesRepository;

    /////////////////////////////////////
    // LEER - Obtener todos los autores
    /////////////////////////////////////
    @GetMapping("/estudiantes2")
    public List<Estudiantes> estudiantes() {
        // Recuperar todos los autores de la base de datos
        List<Estudiantes> estudiantes = estudiantesRepository.findAll();
        return estudiantes; // Devolver la lista de autores
    }


    //////////////////////////////////////////
    // CREAR - Crear un nuevo autor
    /////////////////////////////////////////
    @PostMapping("/estudiantes2")
    public Estudiantes crear(@RequestBody Estudiantes estudiantes) {
        return estudiantesRepository.save(estudiantes); // Guardar el nuevo autor en la base de datos
    }

    ////////////////////////////////////////////////
    // ELIMINAR - Eliminar un autor por ID
    ///////////////////////////////////////////////
    @DeleteMapping("/estudiantes2/{id}")
    public ResponseEntity<Boolean> eliminarEstudiantes(@PathVariable int id) {
        // Buscar el autor por ID
        Optional<Estudiantes> estudiantes = estudiantesRepository.findById(id);

        // Verificar si el autor existe
        if (estudiantes.isPresent()) {
            estudiantesRepository.delete(estudiantes.get()); // Eliminar el autor de la base de datos
            return ResponseEntity.ok(true); // Devolver éxito
        } else {
            return ResponseEntity.ok(false); // Devolver falso si el autor no existe
        }
    }
    ///////////////////////////////////////////////////////////
    // EDITAR - Actualizar la información de un autor por ID
    //////////////////////////////////////////////////////////
    @PutMapping("/estudiantes2/{id}")
    public ResponseEntity<Estudiantes> updateUser(@PathVariable int id, @RequestBody Estudiantes autorData) {
        // Buscar el autor por ID
        Optional<Estudiantes> optionalEstudiantes = estudiantesRepository.findById(id);

        // Verificar si el autor existe
        if (optionalEstudiantes.isPresent()) {
            Estudiantes estudiantes = optionalEstudiantes.get();

            // Actualizar los campos del autor con los datos proporcionados
            estudiantes.setNombre(autorData.getNombre());
            estudiantes.setApellido(autorData.getApellido());
            estudiantes.setCurso(autorData.getCurso());

            // Guardar los cambios en la base de datos
            Estudiantes userSaved = estudiantesRepository.save(estudiantes);
            return ResponseEntity.ok(userSaved); // Devolver el autor actualizado
        } else {
            return ResponseEntity.notFound().build(); // Devolver error si el autor no existe
        }
    }

}