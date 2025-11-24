# 📘 Sistema de Gestão de Alunos – Spring Boot (p2_gestao_alunos)

Este projeto é um sistema simples de **gestão de alunos e cursos**, feito para **avaliação** da disciplina de "**Linguagem de Programação III"**, do curso **"Análise e Desenvolvimento de Sistemas"** da instituição **Fatec Baixada Santista - Rubens Lara**. Desenvolvido em **Java com Spring Boot**, seguindo o padrão **MVC (Model–View–Controller)** e utilizando **Spring Data JPA** com o banco em memória **H2**.

O objetivo é consolidar conceitos de POO, persistência, controllers e criação de páginas web com Thymeleaf.

---

## 🏗️ Arquitetura Geral

O sistema utiliza o padrão **MVC**, organizado da seguinte forma:

### **Model**

Representa as entidades do sistema e seu mapeamento para o banco de dados via JPA.

* `Aluno`
* `Curso`

### **Repository**

Interfaces responsáveis pela comunicação com o banco, extendendo `JpaRepository`.

* `AlunoRepository`
* `CursoRepository`

### **Controller**

Gerencia rotas, recebe requisições e envia dados para as views.

* `AlunoController`
* `CursoController`

### **View**

Páginas HTML utilizando **Thymeleaf**.

* Formulários (cadastro/edição)
* Listagens
* Navegação

---

## 🗂️ Funcionalidades

### **Cursos**

* Cadastro de cursos
* Listagem dos cursos cadastrados
* Edição
* Exclusão

**Campos do Curso**:

* nome
* cargaHoraria
* descricao

---

### **Alunos**

* Cadastro de alunos
* Listagem de alunos cadastrados
* Edição
* Exclusão

**Campos do Aluno**:

* nome
* email
* matricula
* curso (selecionado via dropdown)

Validações aplicadas:

* Campos não nulos
* Email válido
* Matrícula obrigatória

O aluno possui um relacionamento **ManyToOne** com o curso.

---

## 🗃️ Banco de Dados H2

O projeto utiliza o banco **H2** para testes, sem necessidade de instalação.

A interface web do banco pode ser acessada em:

```
http://localhost:8080/h2-console
```

(use o JDBC configurado em `application.properties`)

---

## 🌐 Rotas Principais

### **Cursos**

* `/cursos` — listagem
* `/cursos/novo` — cadastro
* `/cursos/editar/{id}` — edição
* `/cursos/excluir/{id}` — exclusão

### **Alunos**

* `/alunos` — listagem
* `/alunos/novo` — cadastro
* `/alunos/editar/{id}` — edição
* `/alunos/excluir/{id}` — exclusão

---

## ▶️ Execução do Projeto

### **Rodar via Maven**

```
mvn spring-boot:run
```

Em seguida, acesse:

```
http://localhost:8080
```

---

## 🛠️ Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring MVC
* Spring Data JPA
* H2 Database
* Thymeleaf
* Maven

---

## 📚 Objetivo Educacional

Este mini-projeto serve para praticar:

* Criação de projetos Spring Boot
* Entidades JPA e relacionamentos
* CRUD completo (Create, Read, Update, Delete)
* Views com Thymeleaf
* Rotas e controllers
* Validações com Bean Validation
* Uso do banco H2

---

[Link do projetinho no yt!]()
