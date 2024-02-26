# Microservicio de Gestión de Usuarios
PROYECTO 100% ACADEMICO.

Este es un microservicio desarrollado en Java con Spring Boot para la creación y recuperación de usuarios. Permite a los usuarios registrarse, iniciar sesión y acceder a su información.


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

### Puntos finales
#### Registro de Usuario
- **URL:** /sign-up
- **Método HTTP:** POST
- **Descripción:** Punto final para crear un nuevo usuario.
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
  "id": "8222243f-953f-4dde-8541-a7e52cbee8ae",
  "name": "Andre",
  "lastName": "Josefa",
  "birthdate": "2024-02-15",
  "documentNumber": "33456876",
  "email": "Josefa-Martinez@live.com",
  "phone": "12322224567890",
  "status": "todo"
}
```
- **Persistencia de Datos:**
    - El usuario se persiste en una base de datos utilizando Spring Data ,Jakarta y H2.
     
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