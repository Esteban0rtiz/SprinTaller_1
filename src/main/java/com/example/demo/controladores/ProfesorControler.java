package com.example.demo.controladores;

import com.example.demo.entidades.Profesores;
import com.example.demo.repositorios.ProfesoresRepository;
import com.example.demo.repositorios.ProfesoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ProfesorControler {

    @Autowired
    ProfesoresRepository profesoresRepository;

    // READ
    @GetMapping("/autores")
    public String autor(Model model){

        List<Profesores> autores = profesoresRepository.findAll();
        model.addAttribute("autores", autores);

        return "/autor/autor";
    }

    // CREAR
    @GetMapping("/autor/form")
    public String formulario(Model model){
        model.addAttribute("autor", new Profesores());

        return "/autor/formulario";
    }

    @PostMapping("/autor/form")
    public String crear( Profesores profesores){
        profesoresRepository.save(profesores);
        return "redirect:/autores";
    }

    /////ACTUALIZAR
    @GetMapping("/autor/editar/{id}")
    public String actualizar(@PathVariable int id, Model model){

        Optional<Profesores> autor = profesoresRepository.findById(id);
        model.addAttribute("autor", autor);

        return "autor/formulario";
    }


    //Eliminar
    @GetMapping("/autor/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        profesoresRepository.deleteById(id);

        return "redirect:/autores";

    }

}
