# Trabalho de ECM251 - Linguagens de Programação, 2021.

## **Grupo 12**
* Rodrigo Machado Pedreira    &emsp;             18.01569-7  &emsp;  Lab. 2
* Gustavo Lourenço  &emsp; &emsp; &emsp; &emsp;  19.00345-5  &emsp;  Lab. 3
* Conrado Pupo Azzalin     &emsp;&emsp;&emsp;    19.01490-2  &emsp;  Lab. 3

[<span style="font-size:14px;">Repositorio GitHub</span>](https://github.com/Rodrigo-Pedreira/T3-ECM251_2021-FronteBack)
- - -
## Sobre o projeto

A proposta do trabalho é criar um website de reviews. Pode ser de filmes, livros, animes, ou outros temas. Nosso grupo escolheu avaliar filmes.

São tres os componentes principais do projeto: *back-end*, *front-end* e um *banco de dados*.

#### Back-end
Foi escrito na linguagem *Kotlin*, utiliza o *Mavem* como gerenciador de projeto e *ktor* para criar o servidor web.

#### Front-end
Foi escrito na linguagem *Flutter*, é muito simples com poucas funcionalidades mas desmpenha o papel necessario para o trabalho.

#### Banco de dados
Utilizamos o *MariaDB* como gerenciador do banco. Este roda numa maquina virtual local.  

### Um pouco mais sobre o projeto
Criamos um website em que o usuario pode postar reviews e também visualizar e avaliar reviews feitas por outras pessoas.  

O tanto o site quanto o banco de dados rodam no localhost e no momento não são acessíveis pela internet.  

O banco de dados, gerenciado com *MariaDB* roda numa maquina virtual. Este tem tres tabelas: uma para usuarios, uma para reviews e uma para filmes.

## Diagrama do banco de dados

![Diagrama do banco de dados](./DiagramaDB.jpeg)

<details>
<summary>Codigo MySQL</summary>

```sql
CREATE TABLE Films (
	id       INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name     TEXT    NOT NULL,
	genre    TEXT    NOT NULL,
	director TEXT    NOT NULL,
	date     TEXT    NOT NULL);

CREATE TABLE reviews (
	id      INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	idUser  INTEGER NOT NULL,
	idFilm  INTEGER NOT NULL,
	review  TEXT    NOT NULL,
	likes   INTEGER NOT NULL,
	score   REAL    NOT NULL,
	data    TEXT    NOT NULL);

CREATE TABLE Users (
	id       INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name     TEXT    NOT NULL,
	password TEXT    NOT NULL,
	email    TEXT    NOT NULL);

INSERT INTO Films (name,genre,director,date)
VALUES	('The Avengers','action','Joss Whendon','27/04/2012'),
	    ('Avengers: Age of Ultron','action','Joss Whendon','01/05/2015'),
	    ('Grown Ups','comedy','Dennis Dugan','25/06/2010'),
	    ('Grown Ups 2','comedy','Dennis Dugan','12/07/2013');

INSERT INTO Users (name,password,email)
VALUES	('Max','M@x1Mu$','max.10@hotmail.com'),
	    ('Mel','Mel1F1c@D0rA','mel.lado@hotmail.com'),
	    ('Stella','C0$73ll@','cos.stela@hotmail.com');

INSERT INTO reviews (idUser,idFilm,review,likes,score,data)
VALUES	(1,1,'Muito Bom',50,4.3,'09/10/2021'),
	    (2,1,'Quero mais!!',45,4.6,'10/10/2021'),
	    (1,2,'Legal de mais',65,4.7,'10/05/2021'),
	    (3,3,'Ri muito',35,3.8,'08/03/2021');

SELECT * FROM Users;

SELECT * FROM Films;

SELECT * FROM reviews;
```
</details>