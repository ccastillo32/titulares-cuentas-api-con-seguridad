DROP TABLE IF EXISTS usuarios_roles;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS rol;

DROP TABLE IF EXISTS titular_juridico;
DROP TABLE IF EXISTS titular_fisico;
DROP TABLE IF EXISTS titular;
DROP TABLE IF EXISTS tipo_titular;


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

-- Tipos de titulares

CREATE TABLE tipo_titular (
	id INTEGER (3) NOT NULL,
	nombre VARCHAR(50) not null,
	habilitado BOOLEAN , -- Para activar o inactivar
	PRIMARY KEY (id)
);

-- Titular (Tabla común)

CREATE TABLE titular (
	id INTEGER NOT NULL AUTO_INCREMENT,
	cuit VARCHAR(13) NOT NULL,
	tipo INTEGER (3) NOT NULL,
	habilitado BOOLEAN, -- Para activar o inactivar
	PRIMARY KEY (id),
	FOREIGN KEY (tipo) REFERENCES tipo_titular (id)
);

-- Titular físico

CREATE TABLE titular_fisico (
	id INTEGER NOT NULL AUTO_INCREMENT,
	dni VARCHAR(10) NOT NULL,
	nombre VARCHAR(80) NOT NULL,
	apellido VARCHAR(250) NOT NULL,
	titular_id INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (id) REFERENCES titular (id)
);

-- Titular jurídico

CREATE TABLE titular_juridico (
	id INTEGER NOT NULL AUTO_INCREMENT,
	razon_social VARCHAR(100) NOT NULL,
	anio_fundacion INTEGER(5) NOT NULL,
	titular_id INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (id) REFERENCES titular (id)
);

