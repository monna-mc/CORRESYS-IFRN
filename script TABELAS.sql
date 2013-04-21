
CREATE TABLE administrador(

    id INT NOT NULL,
    matricula VARCHAR(20),
    nome VARCHAR(150),
    email VARCHAR(150),
    senha VARCHAR(30)
	
);


CREATE TABLE aluno (

    id INT NOT NULL,
    matricula VARCHAR(20),
    nome VARCHAR(150),
    email VARCHAR(150),
    senha VARCHAR(30),
    curso VARCHAR(150),
    turma VARCHAR(150)
);

CREATE TABLE corretor(

    id INT NOT NULL,
    matricula VARCHAR(20),
    nome VARCHAR(150),
    email VARCHAR(150),
    senha VARCHAR(30)
	
);


CREATE TABLE redacao(

   id INT NOT NULL,
   tema VARCHAR(250),
   titulo VARCHAR(250),
   nota NUMERIC(2,1),
   status VARCHAR(30),   
   matriculaCorretor VARCHAR(20),
   matriculaAluno VARCHAR(20)
);

