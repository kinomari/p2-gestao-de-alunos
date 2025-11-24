package com.example.p2gestaoalunos.config;

import com.example.p2gestaoalunos.model.Aluno;
import com.example.p2gestaoalunos.model.Curso;
import com.example.p2gestaoalunos.repository.AlunoRepository;
import com.example.p2gestaoalunos.repository.CursoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final CursoRepository cursoRepo;
        private final AlunoRepository alunoRepo;
        public DataLoader(CursoRepository cursoRepo, AlunoRepository alunoRepo) {
            this.cursoRepo = cursoRepo;
            this.alunoRepo = alunoRepo;
        }

    @Override
    public void run(String... args) throws Exception {
        if (cursoRepo.count() == 0) {
            Curso c1 = new Curso(); c1.setNome("Engenharia de Software"); c1.setCargaHoraria(1200); c1.setDescricao("Bacharelado");
            Curso c2 = new Curso(); c2.setNome("Sistemas de Informação"); c2.setCargaHoraria(3000); c2.setDescricao("Bacharelado");
            cursoRepo.save(c1); cursoRepo.save(c2);
        }
            if (alunoRepo.count() == 0) {
                Curso eng = cursoRepo.findAll().stream().filter(c -> "Engenharia de Software".equals(c.getNome())).findFirst().orElse(null);
                Curso sis = cursoRepo.findAll().stream().filter(c -> "Sistemas de Informação".equals(c.getNome())).findFirst().orElse(null);

                Aluno a1 = new Aluno(); 
                a1.setNome("Fernanda Lima"); 
                a1.setMatricula("3265897"); 
                a1.setEmail("felima@email.com"); 
                a1.setCurso(eng);

                Aluno a2 = new Aluno(); 
                a2.setNome("Solano Gomes"); 
                a2.setMatricula("1547823"); 
                a2.setEmail("golanosomes@email.com"); 
                a2.setCurso(sis);

                alunoRepo.save(a1); 
                alunoRepo.save(a2);
            }
        }
}
