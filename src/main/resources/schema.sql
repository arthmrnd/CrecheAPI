CREATE TABLE responsavel (id_responsavel SERIAL PRIMARY KEY, nome VARCHAR(255), idade VARCHAR(255), telefone VARCHAR(255), cep VARCHAR(255));
CREATE TABLE professor (id_professor SERIAL PRIMARY KEY, nome VARCHAR(255), serie VARCHAR(255), cep VARCHAR(255));
--CREATE TABLE sala (id_sala SERIAL PRIMARY KEY, id_professor INT FOREIGN KEY REFERENCES professor(id_professor));
--CREATE TABLE crianca (id_crianca SERIAL PRIMARY KEY, nome VARCHAR(255), idade VARCHAR(255), id_responsavel SERIAL FOREIGN KEY REFERENCES responsavel(id_responsavel), id_sala SERIAL FOREIGN KEY REFERENCES sala(id_sala));