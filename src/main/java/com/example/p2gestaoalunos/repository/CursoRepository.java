package com.example.p2gestaoalunos.repository;

import com.example.p2gestaoalunos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
