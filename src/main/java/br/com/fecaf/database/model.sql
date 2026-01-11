CREATE DATABASE IF NOT EXISTS db_biblioteca;

USE db_biblioteca;

CREATE TABLE tbl_livros (
    id INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(150) NOT NULL,
    genero VARCHAR(100),
    ano_publicacao INT,
    preco DECIMAL(10,2),
    paginas INT,
    status VARCHAR(20),
    capa VARCHAR(300),
    PRIMARY KEY (id)
);

INSERT INTO tbl_livros
(titulo, autor, genero, ano_publicacao, preco, paginas, status, capa)
VALUES
(
  '1984',
  'George Orwell',
  'Distopia',
  1949,
  120.00,
  328,
  'disponivel',
  'https://m.media-amazon.com/images/I/71kxa1-0mfL._SY425_.jpg'
 ),
(
 'A Sociedade do Anel',
 'J. R. R. Tolkien',
 'Fantasia',
 1954,
 79.90,
 576,
 'disponivel',
 'https://m.media-amazon.com/images/I/81hCVEC0ExL._SY466_.jpg'
),
(
 'As Duas Torres',
 'J. R. R. Tolkien',
 'Fantasia',
 1954,
 79.90,
 464,
 'disponivel',
 'https://m.media-amazon.com/images/I/81lQ5N0QwJL._SY466_.jpg'
),
(
 'O Retorno do Rei',
 'J. R. R. Tolkien',
 'Fantasia',
 1955,
 89.90,
 544,
 'disponivel',
 'https://m.media-amazon.com/images/I/71+4uDgt8JL._SY466_.jpg'
),
(
 'O Hobbit',
 'J. R. R. Tolkien',
 'Fantasia',
 1937,
 69.90,
 336,
 'disponivel',
 'https://m.media-amazon.com/images/I/91zdxRRvabL._SY466_.jpg'
),
(
 'Nas Montanhas da Loucura',
 'H. P. Lovecraft',
 'Terror Cósmico',
 1936,
 59.90,
 208,
 'disponivel',
 'https://m.media-amazon.com/images/I/716uwVltD4L._SY466_.jpg'
);

SELECT * FROM tbl_livros;

DESCRIBE tbl_livros;



