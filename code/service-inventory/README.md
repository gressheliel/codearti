# Generar imagenes con Docker
- docker-compose up -d
- docker-compose down

# Generar contrato de Api 
- Contract First, Api First
- https://editor-next.swagger.io/
- Secciones importantes del service-inventory.yml
  - openapi: 3.0.1
  - info: informacion general
  - servers: urlServer + basePath + endpoint
  - tags: Agrupación lógica de los endpoints
  - paths: Definición de los endpoints
  - components: Request, estructura de classes pojo

# Agregar profiles
- spring.profiles.active=dev

# Librerias
- Web Reactive
- Lombok
- Data R2DBC

# MySQL Reactive dependencia
```
       <dependency>
			<groupId>io.asyncer</groupId>
			<artifactId>r2dbc-mysql</artifactId>
			<version>0.9.1</version>
		</dependency>
```

# Plugins para generar el contrato de la API
- Revisar la sección de plugins en el pom.xml
- mvn clean compile install
- Los comandos anteriores se ejecutan desde la IDE
- Los archivos generados se encuentran en la carpeta target/generated-sources/openapi

# Creación e importación de código generado
- Generar packages
  - model.mapper y model.entity
  - repository
  - service
  - expose

# Si no reconoce los classes generadas por el plugin
En intellij en la carpeta:
target/generated-sources/openapi/src/main/java
click derecho y Mark Directory as > Generated Sources Root 

# Map vs FlatMap
- Map: Se usa para transformar un objeto a otro objeto.
- FlatMap: Se usa para transformar un objeto a un flujo de objetos (Mono, Flux).

InventoryResponse -> torta
Mono -> caja de tortas

Mono<Mono<InventoryResponse>> -> llamar a flatMap para obtener la torta
