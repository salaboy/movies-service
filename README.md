# Simple Movie Proxy Service
Currently it interacts with OMDB and TheMovieDB public services. 
For both services you need to get Keys to interact with their endpoints.

You can provide the keys inside the application.properties file

```
omdb.key=<ADD YOUR KEY HERE> 
themoviedb.key=<ADD your Key HERE>
```

Or you can export ENVIRONMENT VARIABLES to not commit the keys to the repository
```
export OMDB_KEY=<ADD YOUR KEY HERE>
export THEMOVIEDB_KEY=<ADD YOUR KEY HERE>
```

# Compile, Package & Run

You can compile, package and locally install the project with Maven
```$xslt
mvn clean install
```

Run with:
```$xslt
mvn spring-boot:run
```

## Docker
You can build a docker image and run it with:
```$xslt
docker build -t salaboy/movie-proxy .
```
and run with 
```$xslt
docker run -it -p8080:8080 salaboy/movie-proxy 
```

# Endpoints

By default the search will use OMDB service. 

- GET /{movieTitle} (ie. /sidekicks)
    - Params 
      - apiName (OMDB or TheMovidDB)
      

# TODOs
- Add unified Movie Model (if it is needed), now each API returns its own format
- Add Swagger for OPEN API docs
- Add error handling for failing requests
- Add Security
- Add Spring Cloud Kubernetes Config Property Source Locator for Keys in Kubernetes Secrets
- Document how to run with Docker and how to deploy to kubernetes (all the descriptors are already provided) 
- Test with Istio Circuit Breaker Retries to external services
 
