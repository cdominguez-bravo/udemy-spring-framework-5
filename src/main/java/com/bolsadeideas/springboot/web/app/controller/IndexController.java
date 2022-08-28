package com.bolsadeideas.springboot.web.app.controller;

import com.bolsadeideas.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/index", "/", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework con model!");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Carlos");
        usuario.setApellido("Dominguez");
        usuario.setEmail("carlos@correo.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de usuarios");
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = Arrays.asList(new Usuario("Andres", "Guzman", "andres@correo.com"),
                new Usuario("John", "Doe", "john@correo.com"),
                new Usuario("Jane", "Doe", "jane@correo.com"));
        return usuarios;
    }

}
