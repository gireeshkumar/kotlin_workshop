# kotlin_workshop

Building REST API with Kotlin and Spring Boot , optionally with Quarkus and Docker

## with_quarkus

 Project contains REST API code with Quarkus libraries

### prerequisite

- Kotlin
- Gradle
- IntelliJ IDE
- Docker

### Steps

- Use Spring initializer to create the project structure
- <https://start.spring.io/>
- Add Dependencies , Web and JPA
- Comment out the JPA dependencies in build.gradle.kts file
  - Will enable this later when we work on databse
- Add your custom controllers
  
To Build the project

```shell
./gradlew build
```

To Run the project

```shell
./gradlew bootRun
```

## with_springboot

   Project contains REST API code with Spring boot libraries

### prerequisite

- Kotlin
- Gradle
- IntelliJ IDE
- Docker
- Quarkus CLI <https://quarkus.io/guides/cli-tooling>
- GraalVM (optional- Only if required to build native executable)

### Steps

https://quarkus.io/guides/kotlin

- Create a new Quarkus project with the below command
  ```shell
    quarkus create app org.acme:rest-kotlin-quickstart \
        --extension='kotlin,resteasy-reactive-jackson' --gradle-kotlin-dsl
  ```
- Once created add your own REST Resources
  
To build & run

```shell
quarkus dev
```
