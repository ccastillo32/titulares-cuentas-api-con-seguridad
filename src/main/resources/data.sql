-- Usuarios

INSERT INTO usuario (username, password, nombre, apellido, habilitado) 
VALUES ('cristian', '$2a$10$5NDv1BxoYg6YSQWV7bxS3.ArWxa9lOFxfrQerx.2.QHkQoqSdLoIG', 'Cristian', 'Castillo', TRUE); -- 2019


-- Rol

INSERT INTO rol (nombre) VALUES ('ROLE_USER');

-- Roles x Usuario

INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1,1);

-- Tipos de titulares

INSERT INTO tipo_titular (id, nombre, habilitado) VALUES (1, 'FISICO', TRUE);
INSERT INTO tipo_titular (id, nombre, habilitado) VALUES (2, 'JURIDICO', TRUE);

-- Titular (Tabla común)

INSERT INTO titular (cuit, tipo, habilitado) VALUES ('20-21321345-9', 1, TRUE);
INSERT INTO titular (cuit, tipo, habilitado) VALUES ('20-21345645-8', 1, TRUE);
INSERT INTO titular (cuit, tipo, habilitado) VALUES ('30-70860396-8', 2, TRUE);

-- Titular físico

INSERT INTO titular_fisico (dni, nombre, apellido, titular_id ) VALUES ('21321345', 'MARIA ANGELA', 'PEREZ POLO', 1);
INSERT INTO titular_fisico (dni, nombre, apellido, titular_id ) VALUES ('21345645', 'RAUL ANTONIO', 'VELEZ VELEZ', 2 );

-- Titular jurídico

INSERT INTO titular_juridico (razon_social, anio_fundacion, titular_id ) VALUES ('TECSO', 2002, 3 );
