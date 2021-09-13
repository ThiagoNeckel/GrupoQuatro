CREATE TABLE marca(
	id SERIAL PRIMARY KEY NOT NULL,
	nome VARCHAR(45) NOT NULL
);

CREATE TABLE produto (
	id SERIAL PRIMARY KEY NOT NULL,
	descricao VARCHAR(45) NOT NULL,
	marca INTEGER,
	FOREIGN KEY(marca) REFERENCES marca (id)
);

CREATE TABLE pessoa (
	id SERIAL PRIMARY KEY,
	nome TEXT,
	indentificacao VARCHAR(14) NOT NULL,
	tipoPessoa VARCHAR(45) NOT NULL
	
);

CREATE TABLE estoque (
	Produto INTEGER PRIMARY KEY NOT NULL,
	quantidade int NOT NULL,
	valor NUMERIC NOT NULL
	FOREIGN KEY(Produto) REFERENCES produto (id)
);

CREATE TABLE compra (
	id SERIAL PRIMARY KEY NOT NULL,
	data TIMESTAMP NOT NULL,
	pessoa INTEGER NOT NULL,
	estoque INTEGER NOT NULL,
	FOREIGN KEY(pessoa) REFERENCES pessoa (id),
	FOREIGN KEY(estoque) REFERENCES estoque (produto)
);


CREATE TABLE venda (
	id INTEGER PRIMARY KEY NOT NULL,
	data TIMESTAMP NOT NULL,
	pessoa INTEGER NOT NULL,
	estoque INTEGER NOT NULL,
	FOREIGN KEY(pessoa) REFERENCES pessoa (id),
	FOREIGN KEY(estoque) REFERENCES estoque (produto)
);


CREATE VIEW vendaestoque AS SELECT p.id , p.nome, p.indentificacao, p.tipopessoa, v."data" , e.produto, e.quantidade, e.valor  FROM pessoa p inner join venda v on v.id = p.id join estoque e on e.produto = v.estoque;


CREATE VIEW compraestoque AS SELECT p.id , p.nome, p.indentificacao, p.tipopessoa, c."data", e.produto, e.quantidade, e.valor  FROM pessoa p inner join compra c on c.id = p.id join estoque e on e.produto = c.estoque;

CREATE VIEW marcaProduto AS SELECT p.id , p.descricao, m.nome  FROM produto p inner join marca m on m.id = p.marca;

CREATE VIEW ProdutoEstoque AS SELECT p.id , p.descricao, m.nome , e.quantidade, e.valor FROM produto p inner join marca m on m.id = p.marca join estoque e on p.id = e.produto; 
