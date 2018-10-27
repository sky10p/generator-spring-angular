# Spring - Angular Project

## Usage

Tenemos los siguiente submódulos y paquetas

* business-logic
  * Utilidades, Servicios
* data
  * Modelos, Interfaces, Dao
* multimodule
  * Parent Module (For compile with maven)
* persistence
  * Entities, Repositories, Migraciones bases de datos.
* rest
  * Api Rest
* webapp
  * Página Web (Angular)

## Configuración base de datos

### Migraciones automáticas

Scripts en <%= persistence_name %>/src/main/resources/db/migration/{databaseType}

### Configuración de conexión

Cambiar Property spring.profiles.active={databaseType}

<%= rest_name %>/src/main/resources/application-{database}.properties
or
<%= rest_name %>/src/main/resources/application-yml
