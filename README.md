# Email API

Este repositorio contiene una API REST escrita en Java que gestiona una lista de emails con la siguiente estructura JSON:

```json
{
    "id": 1,
    "remitente": "example1@example.com",
    "destinatario": "example2@example.com",
    "asunto": "Asunto del email",
    "cuerpo": "Cuerpo del email",
    "fecha": "2023-01-01T00:00:00Z"
}
```

## Generación del Proyecto con Spring Initializr

Spring Initializr es una herramienta que facilita la creación y configuración inicial de aplicaciones Spring Boot. Para generar el esqueleto del proyecto sigue los siguientes pasos:

1. **Acceder a la Web**: Visita [start.spring.io](https://start.spring.io).
2. **Configurar el Proyecto**:
   - Selecciona el tipo de proyecto (Maven).
   - Elige el lenguaje de programación (Java).
   - Configura la versión de Spring Boot (recomendable dejar la versión por defecto).
   - Rellena los detalles del proyecto (grupo, nombre del artefacto, versión de Java).
3. **Añadir Dependencias**:
   - Añade las dependencias `Spring Web` y `Lombok`.
4. **Generar el Proyecto**:
   - Haz clic en "Generate" para descargar un archivo `.zip` con la estructura del proyecto.
5. **Importar a tu IDE**:
   - Descomprime el archivo y abre el proyecto en tu IDE favorito (por ejemplo, IntelliJ IDEA).

## Instalación y Configuración de Postman

Postman es una herramienta que permite realizar pruebas de APIs. Para el uso que vamos a hacer en este proyecto, no es necesario crear una cuenta en Postman, podemos usar la versión lightweight API client.

Descarga e instala Postman desde [postman.com](https://www.postman.com).

## Estructura del Proyecto

Se trata de un proyecto ejemplo muy sencillo de API para gestionar emails en el tan solo se han creado 3 Packages y 3 clases, que son las siguientes:

### 1. **Package `models`**:
   - **Clase `Email`**:
     - Esta clase representa un email con atributos como `id`, `remitente`, `destinatario`, `asunto`, `cuerpo` y `fecha`. Utiliza anotaciones de Lombok para reducir el código repetitivo.

### 2. **Package `controller`**:
   - **Clase `EmailController`**:
     - Esta clase maneja las solicitudes HTTP. Utiliza las anotaciones de Spring para mapear las rutas y gestionar las operaciones CRUD (crear, leer, actualizar, eliminar) de los emails. Los principales métodos son:
       - `precesarEmail`: Carga una lista de emails.
       - `getAllEmails`: Devuelve todos los emails.
       - `getEmailById`: Devuelve un email específico basado en su ID.
       - `actualizarEmail`: Actualiza un email específico basado en su ID.
       - `eliminarEmail`: Elimina un email específico basado en su ID.

### 3. **Package `services`**:
   - **Clase `EmailService`**:
     - Esta clase proporciona los métodos de negocio para gestionar la lista de emails. Actúa como un intermediario entre el controlador y los datos. Los principales métodos son:
       - `addEmail`: Añade un nuevo email a la lista.
       - `getAllEmails`: Devuelve la lista completa de emails.
       - `getEmailById`: Devuelve un email basado en su ID.
       - `actualizarEmail`: Actualiza los detalles de un email existente.
       - `eliminarEmail`: Elimina un email basado en su ID.

## Pruebas de Funcionamiento

1. **Arrancar la Aplicación**:
   - En IntelliJ ejecuta el comando `mvn spring-boot:run`.
2. **Abrir Postman**.
3. **Cargar Emails**:
   - Selecciona `POST` y escribe `localhost:8080/cargarEmails`.
   - Selecciona `Body`, `raw` y `JSON`.
   - Pega la lista de emails en formato JSON y haz clic en `Send`. Debería aparecer un mensaje confirmando la carga de emails.
4. **Listar Todos los Emails**:
   - Selecciona `GET` y escribe `localhost:8080/emails`.
5. **Listar un Email por ID**:
   - Selecciona `GET` y escribe `localhost:8080/email/{id}`.
6. **Eliminar un Email**:
   - Selecciona `DELETE` y escribe `localhost:8080/email/{id}`.
7. **Actualizar un Email**:
   - Selecciona `PUT` y escribe `localhost:8080/email/{id}`.
   - En el cuerpo, pasa el objeto email con los nuevos datos en formato JSON.

Este README proporciona la guía básica para iniciar y probar la API REST de gestión de emails. Si tienes alguna pregunta o sugerencia, no dudes en abrir una issue en el repositorio.
