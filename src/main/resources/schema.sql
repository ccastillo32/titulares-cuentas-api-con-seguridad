DROP TABLE IF EXISTS usuarios_roles;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS rol;


CREATE TABLE usuario (
	id INTEGER NOT NULL AUTO_INCREMENT,
	username VARCHAR(20) NOT NULL,
	password VARCHAR(70) NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	apellido VARCHAR(100) NOT NULL,
	habilitado BOOLEAN,
	PRIMARY KEY (id)
);

CREATE TABLE rol (
	id INTEGER NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE usuarios_roles (
	usuario_id INTEGER NOT NULL,
	rol_id INTEGER NOT NULL,
	PRIMARY KEY (usuario_id, rol_id),
	FOREIGN KEY (usuario_id) REFERENCES usuario (id),
	FOREIGN KEY (rol_id) REFERENCES rol (id)
);


