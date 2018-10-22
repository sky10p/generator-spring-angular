# Spring - Angular Project

## Usage

Tenemos los siguiente submódulos y paquetas

* uhis-business-logic
  * Utilidades, Servicios
* uhis-data
  * Modelos, Interfaces, Dao
* uhis-multimodule
  * Parent Module (For compile with maven)
* uhis-persistence
  * Entities, Repositories, Migraciones bases de datos.
* uhis-rest
  * Api Rest
* uhis-webapp
  * Página Web (Angular)

## Configuración base de datos

### Migraciones automáticas

Scripts en uhis-persistence/src/main/resources/db/migration/{databaseType}

### Configuración de conexión

Cambiar Property spring.profiles.active={databaseType}

uhis-rest/src/main/resources/application-{database}.properties
or
uhis-rest/src/main/resources/application-yml
