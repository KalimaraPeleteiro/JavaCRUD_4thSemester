-- Script que deve ser rodado para criar as tabelas.
CREATE TABLE projetos(
    id integer,
    titulo_projeto varchar(100),
    cidade varchar(50),
    estado varchar(2),
    categoria varchar(100),
    descricao varchar(1000),

    primary key(id)
);

CREATE TABLE participantes_projeto(
    cpf varchar(11),
    nome varchar(100),
    email varchar(100),
    telefone varchar(11),
    projeto integer,

    primary key(cpf),
    foreign key(projeto) references projetos(id)
);