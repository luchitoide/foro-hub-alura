CREATE TABLE usuario(
    id BIGINT generated always as identity not null primary key,
    nombre varchar(200) not null,
    correo varchar(200) not null,
    clave varchar(255) not null
);