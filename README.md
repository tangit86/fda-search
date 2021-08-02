## Prerequisites

**Maven** and **Java** are required in order to build/test/run the application.
## How to build

`mvn clean install -DskipTests=true`

## How to run tests

`mvn test`

## How to run 

`java -jar target/fda-search-0.0.1-SNAPSHOT.jar --spring.profiles.active=production --h2.path=~/fdaDbprod`

The above command sets the active profile to `production` and also provides the path where the H2 DB will be saved as a file.


## Documentation

Navigate to `http://localhost:8080/swagger-ui/` for a Swagger view of the exposed endpoints.
An OpenAPI 3.0 yaml is also found under `resources/mainapp.yml` and is also used to generate the exposed interfaces.

* NOTE: The Swagger view is not fully representing the API description that is found in the yaml file