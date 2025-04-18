CREATE TABLE atracao_cliente (
    id SERIAL PRIMARY KEY,
    id_atracao INTEGER NOT NULL,
    id_ingresso INTEGER NOT NULL,
    horario_uso TIMESTAMP WITHOUT TIME ZONE NOT NULL
);


CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100),
    telefone VARCHAR(15),
    cpf VARCHAR(11) UNIQUE NOT NULL,
    username VARCHAR(50),
    password VARCHAR(50)
);


CREATE TABLE ingresso (
    id SERIAL PRIMARY KEY,
    cpf_cliente CHAR(11) NOT NULL,
    id_bilheteria INTEGER NOT NULL,
    data_venda DATE NOT NULL,
    pagamento VARCHAR(20) NOT NULL,
    timestamp_venda TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    nome_atracao_ingresso VARCHAR(50)
);

CREATE TABLE atracao (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    horario_inicio TIME WITHOUT TIME ZONE NOT NULL,
    horario_fim TIME WITHOUT TIME ZONE NOT NULL,
    capacidade INTEGER NOT NULL
);



CREATE TABLE bilheteria (
    id SERIAL PRIMARY KEY,
    preco NUMERIC(10, 2) NOT NULL,
    horario_funcionamento TIME WITHOUT TIME ZONE NOT NULL,
    funcionamento BOOLEAN NOT NULL,
    quantidade_disponivel INTEGER NOT NULL,
    abertura DATE NOT NULL
);



ALTER TABLE ingresso
ADD CONSTRAINT fk_bilheteria FOREIGN KEY (id_bilheteria) REFERENCES bilheteria(id);

ALTER TABLE atracao_cliente
ADD CONSTRAINT fk_atracao FOREIGN KEY (id_atracao) REFERENCES atracao(id);

ALTER TABLE atracao_cliente
ADD CONSTRAINT fk_ingresso FOREIGN KEY (id_ingresso) REFERENCES ingresso(id);

select * from bilheteria

ALTER TABLE bilheteria ADD COLUMN preco DECIMAL(10, 2);
ALTER TABLE bilheteria ADD COLUMN horario_fechamento TIME;
ALTER TABLE bilheteria ADD COLUMN funcionamento VARCHAR(100);
ALTER TABLE bilheteria ADD COLUMN quantidade_disponivel INTEGER;
ALTER TABLE bilheteria ADD COLUMN abertura TIME;

ALTER TABLE atracao ADD COLUMN horario_inicio TIME WITHOUT TIME ZONE NOT NULL,
ALTER TABLE atracao ADD COLUMN horario_fim TIME WITHOUT TIME ZONE NOT NULL,
ALTER TABLE atracao ADD COLUMN capacidadeINTEGER NOT NULL;


ALTER TABLE bilheteria DROP COLUMN nome;



