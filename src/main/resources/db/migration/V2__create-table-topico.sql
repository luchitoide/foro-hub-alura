CREATE TABLE topico(
    id bigint generated always as identity not null primary key,
    titulo varchar(100) not null,
    mensaje varchar(255) not null,
    fechaCreacion timestamp not null,
    estado varchar(100),
    autor bigint not null,

    constraint FK_topico_autor_usuario foreign key(autor) references usuario(id)
);