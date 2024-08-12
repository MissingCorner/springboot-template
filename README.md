MC Spring Boot Template

## Requirements

- Docker CE/Desktop: 20 or above
- Java: 17
- Maven: 3.9

## Preparing

- Run `yarn` to install all dependencies
- Clone `sample.env` to `.env` and provide all required environment variables
  ```
  # minimum env to run for local development
  ```

## Backend development

1. Local development:

    a. Using vscode:
      - support OOTB [devcontainer](https://code.visualstudio.com/docs/devcontainers/containers)
      - please make sure all extenstions are enabled after Open project in DevContainer and you're all set

    b. IntelliJ:
      - Use docker to start postgres local: `docker compose up -d postgres`

  - Run: `mvn spring-boot:run` to start application
  - Run: `mvn test` to run test case

2. Dockerize & Run standalone:

- Build/Dockerize: `docker compose build server`

- Run standalone:

  - `docker compose up -d server`
  - with updated code: `docker compose up -d --build server`
    > Tips: if the `docker compose up -d` command fails, please run build command at lease one first

  After successfully running:

  - server hosted at: <http://localhost:8080/>