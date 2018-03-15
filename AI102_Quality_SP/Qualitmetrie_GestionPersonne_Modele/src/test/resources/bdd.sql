drop schema if exists ai102_qualite;
create schema ai102_qualite;
use ai102_qualite;

create table ville (
	id int(11) not null auto_increment,
	libelle varchar(50) not null,
	primary key(id)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

create table cp (
	id int(11) not null auto_increment,
	libelle varchar(50) not null,
	primary key(id)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

create table adresse (
	id int(11) not null auto_increment,
	num varchar(50) not null,
	rue varchar(50) not null,
	id_ville int(11) not null,
	id_cp int(11) not null,
	primary key(id),
	index idx_ville_adresse (id_ville),
	index idx_cp_adresse (id_cp),
	CONSTRAINT fk_ville_adresse 
		FOREIGN KEY (id_ville)
		REFERENCES ville (id),
	CONSTRAINT fk_cp_adresse 
		FOREIGN KEY (id_cp)
		REFERENCES cp (id)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

create table personne (
	id int(11) not null auto_increment,
	nom varchar(50) not null,
	prenom varchar(50) not null,
	mail varchar(150) not null,
	password varchar(50) not null,
	naissance DATETIME not null,
	id_adresse int(11) not null,
	primary key(id),
	index idx_adresse_personne (id_adresse),
	CONSTRAINT fk_adresse_personne 
		FOREIGN KEY (id_adresse)
		REFERENCES adresse (id)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

INSERT INTO ville (id, libelle) VALUES 
	(1, 'PARIS'), (2, 'LYON'), (3, 'MONTROUGE');
INSERT INTO cp (id, libelle) VALUES 
	(1, '75005'), (2, '69003'), (3, '92120');
INSERT INTO adresse (id, num, rue, id_ville, id_cp) VALUES
	(1, '102', 'micile fixe', 1, 1),
	(2, '102', 'micile fixe', 2, 2);
INSERT INTO personne (id, nom, prenom, mail, password, naissance, id_adresse) VALUES 
	(1, 'pers1', 'pers1', 'pers1@app.fr', 'pers1', '2012-12-21', 1),
	(2, 'pers2', 'pers2', 'pers2@app.fr', 'pers2', '2012-12-21', 2),
	(3, 'pers3', 'pers3', 'pers3@app.fr', 'pers3', '2012-12-21', 2);
	
