FROM maven:3.9.7-eclipse-temurin-17-alpine AS builder
WORKDIR build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-alpine AS layers
WORKDIR layer
COPY --from=builder /build/target/template-0.0.1.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM eclipse-temurin:17-jre-alpine AS artifact
WORKDIR /opt/app
RUN addgroup --system appuser && adduser -S -s /usr/sbin/nologin -G appuser appuser
COPY --from=layers /layer/dependencies/ ./
COPY --from=layers /layer/spring-boot-loader/ ./
COPY --from=layers /layer/snapshot-dependencies/ ./
COPY --from=layers /layer/application/ ./
RUN chown -R appuser:appuser /opt/app
USER appuser
HEALTHCHECK --interval=30s --timeout=3s --retries=1 CMD wget -qO- http://localhost:8080/_info | grep name || exit 1
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]