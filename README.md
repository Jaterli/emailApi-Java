
# Gestión de Correos Electrónicos con Spring Boot


Este repositorio contiene una API REST desarrollada en Java utilizando Spring Boot para la gestión de correos electrónicos. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una lista de correos electrónicos almacenados en una base de datos MySQL. Se incluye una guía paso a paso para la configuración y ejecución del proyecto, así como la integración y prueba con herramientas como Postman y XAMPP.

<p>&nbsp;</p>

## Estructura JSON de los Emails

```json
[
{
  "id": 1,
  "remitente": "example1@example.com",
  "destinatario": "example2@example.com",
  "asunto": "Asunto del email",
  "cuerpo": "Cuerpo del email",
  "fecha": "2023-01-01T00:00:00Z"
},
{
  "id": 2,
  "remitente": "example2@example.com",
  "destinatario": "example3@example.com",
  "asunto": "Asunto del email 2",
  "cuerpo": "Cuerpo del email 3",
  "fecha": "2023-01-01T00:00:00Z"
}
]
```

## Requisitos

- Java 17
- Maven
- Spring Boot
- MySQL
- Postman
- XAMPP

## Generación del Proyecto con Spring Initializr

Para comenzar, utilizamos [Spring Initializr](https://start.spring.io) para generar la estructura inicial del proyecto. Sigue estos pasos:

1. **Accede a Spring Initializr**
   - Visita [start.spring.io](https://start.spring.io).

2. **Configura el Proyecto**
   - **Tipo de proyecto**: Selecciona Maven.
   - **Lenguaje**: Selecciona Java.
   - **Versión de Spring Boot**: Deja las versiones por defecto recomendadas.
   - **Detalles del proyecto**: Rellena el grupo, nombre del artefacto y versión de Java.

3. **Añade Dependencias**
   - Añade las dependencias `Spring Web` y `Lombok`.

4. **Genera el Proyecto**
   - Haz clic en "Generate" para descargar un archivo `.zip` con la estructura del proyecto.

5. **Importa el Proyecto a tu IDE**
   - Descomprime el archivo y abre el proyecto en tu IDE favorito (IntelliJ recomendado).

## Configuración del Proyecto

1. **Crea los Paquetes y Clases Necesarios**
   - En el directorio `src/main/java/[nombre proyecto]`, crea los siguientes paquetes y clases:
     - `models`: Clase `Email`.
     - `controller`: Clase `EmailController`.
     - `services`: Clase `EmailService`.
     - `repository`: Interfaz `EmailRepository`.

2. **Configura la Dependencia CrudRepository**
   - CrudRepository es una interfaz proporcionada por Spring Data JPA que ofrece métodos CRUD básicos. Incluye la dependencia en el archivo `pom.xml`.

3. **Configura la Conexión a la Base de Datos MySQL**
   - Modifica el archivo `application.properties` para configurar la conexión a la base de datos:

```properties
spring.application.name=emailApi
spring.datasource.url=jdbc:mysql://localhost:3306/email_db
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true
```

> **Nota:** Cambia los nombres de la base de datos, usuario y contraseña según tu configuración.

4. **Añade la Dependencia del Conector MySQL**
   - Añade la dependencia del conector MySQL en `pom.xml` y actualiza Maven.

## Ejecución de la Aplicación

1. **Ejecuta el Comando `spring-boot:run`**
   - Lanza la aplicación y verifica que no se produzcan errores.

## Instalación de Postman

[Postman](https://www.postman.com) es una herramienta que permite realizar pruebas de APIs. Descarga e instala Postman desde su web oficial. No es necesario crear una cuenta; se puede usar la versión lightweight API client.

## Pruebas de Funcionamiento con Postman

1. **Arranca la Aplicación**
   - Ejecuta `spring-boot:run` en IntelliJ.

2. **Abre Postman**

3. **Realiza las Siguientes Pruebas**

### Crear Emails

- **Método**: `POST`
- **URL**: `localhost:8080/cargarEmails`
- **Configuración**:
  - Selecciona `Body`, `raw`, y en el desplegable selecciona `JSON`.
  - En el cuerpo, pega la lista de emails en formato JSON y haz clic en `Send`.

### Listar Todos los Emails

- **Método**: `GET`
- **URL**: `localhost:8080/emails`

### Listar un Email por ID

- **Método**: `GET`
- **URL**: `localhost:8080/email/{id}`

### Eliminar un Email

- **Método**: `DELETE`
- **URL**: `localhost:8080/email/{id}`

### Actualizar un Email

- **Método**: `PUT`
- **URL**: `localhost:8080/email/{id}`
- **Configuración**:
  - En el cuerpo, pasa el objeto email con los datos nuevos en formato JSON.

## Instalación de XAMPP

[XAMPP](https://www.apachefriends.org/es/index.html) es una distribución de Apache fácil de instalar que contiene MariaDB, PHP y Perl.

1. **Abre XAMPP como Administrador**
   - Inicia el servidor de MySQL.

2. **Verifica la Conexión**
   - Abre `phpMyAdmin` y revisa si se ha creado la tabla especificada en la clase `Email`.

3. **Gestión de Registros**
   - Añade registros nuevos en la tabla a través de `cargarEmails` desde Postman y revísalos también con `phpMyAdmin`.

## Contenidos del Proyecto

- **Email**: Clase modelo que representa un email.
- **EmailController**: Clase controladora que gestiona las rutas de la API.
- **EmailRepository**: Interfaz que extiende `CrudRepository` para operaciones CRUD.
- **EmailService**: Clase de servicio que implementa la lógica de negocio.
- **application.properties**: Archivo de configuración de la aplicación.
- **pom.xml**: Archivo de configuración de dependencias Maven.


Este README proporciona la guía básica para iniciar y probar la API REST de gestión de emails. Si tienes alguna pregunta o sugerencia, no dudes en abrir una issue en el repositorio.
