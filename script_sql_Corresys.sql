-- Table: administrador

-- DROP TABLE administrador;

CREATE TABLE administrador
(
  id bigint NOT NULL,
  email character varying(255),
  matricula character varying(255),
  nome character varying(255),
  senha character varying(255),
  CONSTRAINT administrador_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE administrador
  OWNER TO postgres;


-- Table: aluno

-- DROP TABLE aluno;

CREATE TABLE aluno
(
  id bigint NOT NULL,
  curso character varying(255),
  email character varying(255),
  matricula character varying(255),
  nome character varying(255),
  senha character varying(255),
  turma character varying(255),
  CONSTRAINT aluno_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE aluno
  OWNER TO postgres;


-- Table: corretor

-- DROP TABLE corretor;

CREATE TABLE corretor
(
  id bigint NOT NULL,
  email character varying(255),
  matricula character varying(255),
  nome character varying(255),
  senha character varying(255),
  CONSTRAINT corretor_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE corretor
  OWNER TO postgres;


-- Table: redacao

-- DROP TABLE redacao;

CREATE TABLE redacao
(
  id bigint NOT NULL,
  dat date,
  imagem bytea,
  matriculaaluno character varying(255),
  matriculacorretor character varying(255),
  nota double precision,
  status character varying(255),
  tema character varying(255),
  titulo character varying(255),
  CONSTRAINT redacao_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE redacao
  OWNER TO postgres;


-- Table: sequence

-- DROP TABLE sequence;

CREATE TABLE sequence
(
  seq_name character varying(50) NOT NULL,
  seq_count numeric(38,0),
  CONSTRAINT sequence_pkey PRIMARY KEY (seq_name)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sequence
  OWNER TO postgres;
