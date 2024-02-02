Challenge Backend - README
Este proyecto implementa un backend que expone APIs RESTful para listar items por texto y obtener detalles de un item por su ID.

Requisitos
Java 8 o superior
Maven o Gradle (se utiliza Maven en este ejemplo)
Base de datos en memoria (HSQLDB o H2)
Spring Boot
JPA (EclipseLink, Hibernate u OpenJPA)
Swagger para documentación de API
Pruebas unitarias
Estructura del Proyecto
La estructura del proyecto sigue los estándares de un proyecto Spring Boot:

src/main/java: Código fuente de la aplicación.
src/main/resources: Recursos de la aplicación (configuraciones, archivos estáticos, plantillas, etc.).
src/test: Pruebas unitarias.
Configuración
Clona el repositorio del proyecto desde GitHub.
bash
Copy code
git clone <url-del-repositorio>
cd <nombre-del-proyecto>
Abre el proyecto en tu IDE favorito.
Construcción y Ejecución del Proyecto
bash
Copy code
# Construir el proyecto con Maven
mvn clean install

# Ejecutar la aplicación Spring Boot
mvn spring-boot:run
La aplicación se ejecutará en localhost:8080.

Prueba de Endpoints
Listar Items por Texto
Realiza una solicitud GET a la siguiente URL utilizando Postman o tu herramienta preferida:

bash
Copy code
GET http://localhost:8080/api/items?texto=<texto-a-buscar>
Deberías recibir una respuesta JSON con la lista de ítems que coinciden con el texto proporcionado.

Obtener Item por ID
Realiza una solicitud GET a la siguiente URL utilizando Postman o tu herramienta preferida:

bash
Copy code
GET http://localhost:8080/api/items/<id-del-item>
Deberías recibir una respuesta JSON con el detalle del ítem correspondiente al ID proporcionado.

Documentación de la API (Swagger)
Puedes acceder a la documentación de la API generada por Swagger en:

bash
Copy code
http://localhost:8080/swagger-ui.html
Aquí encontrarás información detallada sobre los endpoints y cómo utilizarlos.