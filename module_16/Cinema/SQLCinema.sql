/*CREATE TABLE Cassa_Prodotto (
	id_Cassa INT NOT NULL,
	id_Cinema INT NOT NULL,
	id_Prodotto INT NOT NULL,
	prezzo NUMERIC NOT NULL,
	quantita NUMERIC NOT NULL
)

ALTER TABLE Cassa_Prodotto
	ADD CONSTRAINT PK_Cassa_Prodotto
	PRIMARY KEY (id_Cassa, id_cinema, id_Prodotto)

ALTER TABLE Cassa_Prodotto
	ADD CONSTRAINT FK_Cassa
	FOREIGN KEY (id_Cassa, id_cinema)
	REFERENCES Cassa(id, id_cinema)
	
ALTER TABLE Cassa_Prodotto
	ADD CONSTRAINT FK_Prodotto
	FOREIGN KEY (id_prodotto)
	REFERENCES Prodotto(id)
*/
/*
CREATE TABLE IF NOT EXISTS Prodotto (
	ID SERIAL NOT NULL PRIMARY KEY,
	NOME VARCHAR(100) NOT NULL,
	TIPO VARCHAR(100) NOT NULL
);

SELECT * FROM Prodotto;

INSERT INTO Prodotto (nome, tipo)
VALUES('Pupazzetto', 'Gadget')

ALTER TABLE Prodotto
	drop CONSTRAINT CK_Tipo
	
ALTER TABLE Prodotto
	ADD CONSTRAINT CK_Tipo
	CHECK (tipo IN ('Snack', 'Bevanda', 'Gadget'))
*/
/*CREATE TABLE Cassa (
	ID SERIAL NOT NULL,
	ID_Cinema INT NOT NULL,
	Tipo VARCHAR(100) NOT NULL
)

ALTER TABLE Cassa
	ADD CONSTRAINT PK_Cassa
	PRIMARY KEY (id, id_cinema)

ALTER TABLE Cassa
	ADD CONSTRAINT FK_Cinema
	FOREIGN KEY (id_cinema)
	REFERENCES Cinema(id)
	
ALTER TABLE Cassa
	ADD CONSTRAINT CK_Tipo
	CHECK (tipo IN ('Fisica', 'Virtuale'))
 */


/*select * from orario

CREATE TABLE Orario (
	orario_inizio TIME NOT NULL,
	giorno DATE NOT NULL,
	titolo_film VARCHAR(100) NOT NULL,
	id_sala INT NOT NULL,
	id_cinema INT NOT NULL
)

ALTER TABLE Orario 
	ADD CONSTRAINT PK_Orario
	PRIMARY KEY (orario_inizio, giorno, titolo_film, id_sala, id_cinema)
	
ALTER TABLE Orario 
	ADD CONSTRAINT FK_Film
	FOREIGN KEY (titolo_film)
	REFERENCES Film(titolo)
	
ALTER TABLE Orario 
	ADD CONSTRAINT FK_Sala
	FOREIGN KEY (id_sala, id_cinema)
	REFERENCES Sala(id, id_cinema)*/
/*
SELECT * FROM Cinema

DELETE FROM Cinema

INSERT INTO Cinema (nome, indirizzo)
VALUES ('Cinema 5', 'Via Fasulla, 127')

CREATE TABLE Cinema (
	ID SERIAL PRIMARY KEY,
	Nome VARCHAR(100) NOT NULL,
	id_indirizzo int NOT NULL
)

/*ALTER TABLE Cinema DROP COLUMN indirizzo
ALTER TABLE Cinema ADD COLUMN id_indirizzo int NOT NULL*/
ALTER TABLE Cinema
	ADD CONSTRAINT FK_Indirizzo
	FOREIGN KEY (id_indirizzo)
	REFERENCES indirizzo(id)

CREATE TABLE Indirizzo (
	ID SERIAL PRIMARY KEY,
	Via VARCHAR(500) NOT NULL,
	Civico VARCHAR(10) NOT NULL,
	Citta VARCHAR(300) NOT NULL
)
*/
/*
SELECT * FROM Sala

CREATE TABLE Sala (
	ID SERIAL,
	ID_Cinema INT,
	Nome VARCHAR(100)
)

ALTER TABLE Sala 
	ADD CONSTRAINT PK_Sala
	PRIMARY KEY (ID, ID_Cinema)

ALTER TABLE Sala 
	ADD CONSTRAINT FK_Cinema
	FOREIGN KEY (ID_Cinema)
	REFERENCES Cinema(ID)
*/

/*
CREATE TABLE Film (
	Titolo VARCHAR(100) NOT NULL PRIMARY KEY,
	Durata SMALLINT NOT NULL
)

ALTER TABLE Film
	ADD CONSTRAINT CK_Durata
	CHECK (durata > 0)

SELECT * FROM Film

INSERT INTO Film (durata, titolo)
VALUES (120, 'Iron Man'),
(126, 'Iron Man 2'),
(130, 'Iron Man 3')

DELETE FROM Film WHERE Titolo LIKE 'Iron Man%'

UPDATE Film SET durata = 125 WHERE Titolo = 'Iron Man'
*/