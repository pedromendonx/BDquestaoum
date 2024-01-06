DROP DATABASE IF EXISTS 20211164010033_aluno;
CREATE DATABASE 20211164010033_aluno;

use 20211164010033_aluno;

CREATE TABLE aluno (
    numero int primary key auto_increment not null,
    nome varchar(100) not null,
    curso varchar(100) unique not null,
    nota1 float not null,
    nota2 float not null,
    nota3 float not null,
    nota4 float not null

);

SELECT * from aluno;
