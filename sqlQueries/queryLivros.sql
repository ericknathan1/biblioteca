CREATE TABLE Livros (
    id INT,
    titulo VARCHAR(255) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    CONSTRAINT pk_livros PRIMARY KEY (id)
);