-- Usuarios

INSERT INTO usuario (username, password, nombre, apellido, habilitado) 
VALUES ('tecso', '$2a$10$5NDv1BxoYg6YSQWV7bxS3.ArWxa9lOFxfrQerx.2.QHkQoqSdLoIG', 'tecso', '', TRUE); -- 2019


-- Rol

INSERT INTO rol (nombre) VALUES ('ROLE_USER');

-- Roles x Usuario

INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1,1);