# api-birthday-day

Este es un microservicio desarrollado en Java con Spring Boot para la creación y recuperación de usuarios. Permite registrar personas, cargarle informacion adicional pos carga,  acceder a su información entre otras casuiticas que se describen luego.


## Características Clave
- Creación de usuarios con validación de datos.
- Recuperación de información de usuarios.
- Almacenamiento de datos de usuarios en una base de datos H2 en memoria.

## Requisitos
- Java 17 o superior.
- Gradle 8 o superior para la gestión de dependencias.
- IDE de desarrollo compatible con Spring Boot (por ejemplo, IntelliJ IDEA o Eclipse).

## Configuración
1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu IDE.
3. Personaliza la configuración de la base de datos en `application.properties`.
4. Compila y ejecuta la aplicación.
5. Datos como contraseñas no sifradas se encuentran en `application.properties`.

## Uso
### Documentación de la API - Registro y Recuperación de Usuarios

Esta documentación describe los puntos finales de la API de registro y recuperación de usuarios para una aplicación Java Spring Boot 2.7. La API permite la creación de nuevos usuarios y la recuperación de usuarios existentes utilizando tokens JWT para la autenticación.

- **Persistencia de Datos:**
    - El usuario se persiste en una base de datos utilizando Spring Data ,Jakarta y H2.
      ¡Tienes toda la razón! Perdona por eso. Aquí tienes la documentación de las rutas HTTP:

### Rutas HTTP
#### Crear Usuario
- **Método HTTP:** POST
- **URL:** /api/persons/
- **Descripción:** Permite crear un nuevo usuario.
- **Contrato de Solicitud:**
```json
{
  "id": "String",
  "name": "String",
  "lastName": "String",
  "birthdate": "String",
  "documentNumber": "String",
  "email": "String",
  "phone": "String",
  "status": "String"
}
```
- **Validaciones:**
  - El correo electrónico debe seguir la expresión regular (aaaaaaa@dominio.com).

- **Campos Opcionales:**
  - Nombre y teléfonos son campos opcionales.
- **Respuesta Exitosa:**
  En caso de éxito, se devuelve el usuario con los siguientes campos:
```json
{
  "id": "String",
  "name": "String",
  "lastName": "String",
  "birthdate": "String",
  "documentNumber": "String",
  "email": "String",
  "phone": "String",
  "status": "String"
}
```
- **Persistencia de Datos:**
  - El usuario se persiste en una base de datos utilizando Spring Data, Jakarta y H2.

#### Obtener Todos los Usuarios
- **Método HTTP:** GET
- **URL:** /api/persons/
- **Descripción:** Obtiene todos los usuarios registrados.

#### Obtener Usuario por ID
- **Método HTTP:** GET
- **URL:** /api/persons/{id}
- **Descripción:** Obtiene un usuario específico según su ID.

#### Actualizar Usuario
- **Método HTTP:** PATCH
- **URL:** /api/persons/update
- **Descripción:** Actualiza la información de un usuario existente.

#### Deshabilitar Usuario
- **Método HTTP:** DELETE
- **URL:** /api/persons/{id}/disable
- **Descripción:** Deshabilita un usuario según su ID.

#### Eliminar Usuario
- **Método HTTP:** DELETE
- **URL:** /api/persons/{id}/delete
- **Descripción:** Elimina permanentemente un usuario según su ID.

¡Espero que esta documentación sea más útil para ti!    
## Contribución
Si deseas contribuir a este proyecto, sigue estos pasos:
1. Haz un fork del repositorio.
2. Crea una nueva rama para tu contribución.
3. Realiza tus cambios y mejoras.
4. Envía una solicitud de extracción a la rama principal.

## Licencia
Este proyecto es puramente académico.

## Contacto
Si tienes preguntas o sugerencias, no dudes en ponerte en contacto con Pablo en vallejos_pablo@live.com.
