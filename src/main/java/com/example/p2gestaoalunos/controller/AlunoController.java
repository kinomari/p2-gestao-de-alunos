package com.example.p2gestaoalunos.controller;

import com.example.p2gestaoalunos.model.Aluno;
import com.example.p2gestaoalunos.repository.AlunoRepository;
import com.example.p2gestaoalunos.repository.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoRepository alunoRepo;
    private final CursoRepository cursoRepo;

    public AlunoController(AlunoRepository alunoRepo, CursoRepository cursoRepo) {
        this.alunoRepo = alunoRepo;
        this.cursoRepo = cursoRepo;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", alunoRepo.findAll());
        return "alunos/list";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("cursos", cursoRepo.findAll());
        return "alunos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Aluno aluno, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cursos", cursoRepo.findAll());
            return "alunos/form";
        }
        if (alunoRepo.existsByMatricula(aluno.getMatricula())) {
            result.rejectValue("matricula", "error.aluno", "Matrícula já cadastrada");
            model.addAttribute("cursos", cursoRepo.findAll());
            return "alunos/form";
        }
        alunoRepo.save(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Aluno a = alunoRepo.findById(id).orElseThrow();
        model.addAttribute("aluno", a);
        model.addAttribute("cursos", cursoRepo.findAll());
        return "alunos/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        alunoRepo.deleteById(id);
        return "redirect:/alunos";
    }
}
