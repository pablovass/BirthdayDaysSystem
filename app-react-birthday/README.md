# app-react-birthday
![imagen del app](https://github.com/pablovass/BirthdayDaysSystem/blob/main/doc/img.png)

Este repositorio es un sistema de gestión de cumpleaños llamado BirthdayDaysSystem, compuesto por una aplicación frontend desarrollada con React 18.2.0 y Vite 5.1.4, y una API backend desarrollada en Java 17 con Spring Boot 3.1.8. La aplicación frontend utiliza librerías como Tailwind CSS y dndkit para funcionalidades específicas.

## Requerimientos de Instalación

### Prerequisitos
- Node.js >= 14.x
- Java 17
- Maven
- Git

## Pasos de Instalación

1. Clona este repositorio en tu máquina local usando Git:
   ```
   git clone https://github.com/tu-usuario/BirthdayDaysSystem.git
   ```

2. Instalación de dependencias:
   - **Frontend**:
     ```bash
     cd frontend
     npm install
     ```
   - **Backend**:
     ```bash
     cd backend
     mvn install
     ```

## Cómo Ejecutar

1. **Backend**:
   ```bash
   cd backend
   mvn spring-boot:run
   ```

2. **Frontend**:
   ```bash
   cd frontend
   npm run dev
   ```

### Nota

Asegúrate de tener la base de datos H2 correctamente configurada en el backend para que las operaciones CRUD funcionen correctamente.

## Enlaces útiles

- [Documentación del proyecto Java](URL_del_archivo_o_página)

# Aplicación de Gestión de Cumpleaños (React)

La aplicación de gestión de cumpleaños es una interfaz amigable desarrollada en React 18.2.0 con Vite 5.1.4. Utiliza librerías como Tailwind CSS para estilos rápidos y dndkit para funcionalidades de arrastrar y soltar.

## Requerimientos de Instalación

### Prerequisitos
- Node.js >= 14.x
- npm o yarn

## Pasos de Instalación

1. Clona este repositorio en tu máquina local usando Git:
   ```
   git clone https://github.com/tu-usuario/BirthdayDaysSystem.git
   ```

2. Navega hasta el directorio del frontend:
   ```
   cd frontend
   ```

3. Instala las dependencias del proyecto:
   ```
   npm install
   ```

## Cómo ejecutar

Para ejecutar la aplicación frontend, utiliza el siguiente comando:
```
npm run dev
```

La aplicación estará disponible en `http://localhost:3000`.
Aquí está la documentación para la API que proporcionaste:

### Rutas HTTP
#### Obtener Todas las Tareas
- **Método HTTP:** GET
- **URL:** /api/persons/
- **Descripción:** Obtiene todas las tareas registradas.

#### Crear Tarea
- **Método HTTP:** POST
- **URL:** /api/persons/
- **Descripción:** Permite crear una nueva tarea.
- **Contrato de Solicitud:**
```json
{
  "task": "String"
}
```
- **Respuesta Exitosa:**
  En caso de éxito, devuelve la tarea creada con los siguientes campos:
```json
{
  "id": "String",
  "task": "String"
}
```

#### Obtener Tarea por ID
- **Método HTTP:** GET
- **URL:** /api/persons/{id}
- **Descripción:** Obtiene una tarea específica según su ID.

#### Actualizar Tarea
- **Método HTTP:** PATCH
- **URL:** /api/persons/update
- **Descripción:** Actualiza la información de una tarea existente.

#### Deshabilitar Tarea
- **Método HTTP:** DELETE
- **URL:** /api/persons/{id}/disable
- **Descripción:** Deshabilita una tarea según su ID.

#### Eliminar Tarea
- **Método HTTP:** DELETE
- **URL:** /api/persons/{id}/delete
- **Descripción:** Elimina permanentemente una tarea según su ID.

### Nota

Para la funcionalidad completa de la aplicación, asegúrate de tener las dependencias instaladas, incluyendo react-router-dom, react-hook-form, y react-dnd.

