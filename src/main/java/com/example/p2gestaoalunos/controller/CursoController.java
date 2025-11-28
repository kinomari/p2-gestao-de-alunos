package com.example.p2gestaoalunos.controller;

import com.example.p2gestaoalunos.model.Curso;
import com.example.p2gestaoalunos.repository.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cursos")
public class CursoController {
    private final CursoRepository cursoRepo;

    public CursoController(CursoRepository cursoRepo) {
        this.cursoRepo = cursoRepo;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cursos", cursoRepo.findAll());
        model.addAttribute("titulo", "Lista de Cursos");
        return "cursos/list";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("curso", new Curso());
        model.addAttribute("titulo", "Novo Curso");
        return "cursos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Curso curso, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Erro ao salvar curso");
            return "cursos/form";
        }
        if (curso != null) {
            cursoRepo.save(curso);
        }
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable long id, Model model) {
        Curso c = cursoRepo.findById(id).orElseThrow();
        model.addAttribute("curso", c);
        model.addAttribute("titulo", "Editar Curso");
        return "cursos/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable long id) {
        cursoRepo.deleteById(id);
        return "redirect:/cursos";
    }
}
