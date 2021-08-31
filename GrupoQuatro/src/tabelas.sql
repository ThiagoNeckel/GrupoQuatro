CREATE TABLE marca(
	idMarca SERIAL PRIMARY KEY NOT NULL,
	nome VARCHAR(45) NOT NULL
);

CREATE TABLE produto (
	idProduto SERIAL PRIMARY KEY NOT NULL,
	descricao VARCHAR(45) NOT NULL,
	idMarca INTEGER,
	FOREIGN KEY(idMarca) REFERENCES marca (idMarca)
);

CREATE TABLE usuario (
	idMatricula SERIAL PRIMARY KEY,
	funcao varchar(45) NOT NULL,
	nome TEXT
);

CREATE TABLE estoque (
	idProduto INTEGER PRIMARY KEY NOT NULL,
	quantidade NUMERIC(20, 2) NOT NULL,
	FOREIGN KEY(idProduto) REFERENCES produto (idProduto)
);

CREATE TABLE compra (
	idCompra SERIAL PRIMARY KEY NOT NULL,
	datahora TIMESTAMP NOT NULL,
	idMatricula INTEGER NOT NULL,
	fornecedor VARCHAR(45) NOT NULL,
	FOREIGN KEY(idMatricula) REFERENCES usuario (idMatricula)
);

CREATE TABLE itemCompra (
	idItemCompra SERIAL PRIMARY KEY NOT NULL,
	idCompra INTEGER NOT NULL,
	idProduto INTEGER NOT NULL,
	quantidade NUMERIC(20, 2) NOT NULL,
	FOREIGN KEY(idCompra) REFERENCES compra (idCompra),
	FOREIGN KEY(idProduto) REFERENCES estoque (idProduto)
);

CREATE TABLE venda (
	idVenda INTEGER PRIMARY KEY NOT NULL,
	datahora TIMESTAMP NOT NULL,
	idMatricula INTEGER NOT NULL,
	FOREIGN KEY(idMatricula) REFERENCES usuario (idMatricula)
);

CREATE TABLE itemVenda (
	idItemVenda INTEGER PRIMARY KEY NOT NULL,
	idVenda INTEGER NOT NULL,
	idProduto INTEGER NOT NULL,
	quantidade NUMERIC(20, 2) NOT NULL,
	FOREIGN KEY(idVenda) REFERENCES venda (idVenda),
	FOREIGN KEY(idProduto) REFERENCES estoque (idProduto)
);