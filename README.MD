
## Foro Hub - Alura

Esta es una API RESTful desarrollada en Java para la creación de un foro que permite gestionar usuarios y temas. La seguridad está implementada con Spring Security y JWT para la autenticación y autorización.

Proyecto realizado como Challenge Final de los cursos Alura.

## Características

- Gestión de usuarios: registro y autenticación.
- Creación, lectura, actualización y eliminación de temas.
- Roles y permisos configurados para usuarios (e.g., administrador, usuario regular).
- Seguridad implementada con JWT (JSON Web Token).
- Manejo de errores y validaciones robustas.

## Tecnologías utilizadas
- Java 17
- Spring Boot 3
- Spring Security
- JWT
- Spring Data JPA (Hibernate)
- PostgreSQL o cualquier base de datos compatible con JPA.
- Lombok para reducir el boilerplate.
- Maven como gestor de dependencias

## 🧰 Endpoints disponibles

### Usuarios

| Método | Endpoint              | Descripción                         | Autenticación |
|--------|-----------------------|-------------------------------------|---------------|
| POST   | `/usuarios/registrar` | Registra un nuevo usuario           | ❌            |
| POST   | `/login`              | Inicia sesión y genera un token JWT | ❌            |
| Get    | `/login`              | Inicia sesión y genera un token JWT | ✔️            |

### Temas

| Método | Endpoint        | Descripción                      | Autenticación |
|--------|-----------------|----------------------------------|---------------|
| GET    | `/topicos`      | Obtiene todos los temas          | ✔️            |
| GET    | `/topicos/{id}` | Obtiene un tema por su ID        | ✔️            |
| POST   | `/topicos`      | Crea un nuevo tema               | ✔️            |
| PUT    | `/topicos/{id}` | Actualiza un tema existente      | ✔️            |
| DELETE | `/topicos/{id}` | Elimina un tema                  | ✔️            |

## Documentacion

La documentacion con OpenApi Specification estara disponible a traves de estos enlaces:
- Para su version con interfaz grafica: `http://server:port/swagger-ui.html`
- Para su version en JSON: `http://server:port/v3/api-docs`


