# Etapa 1: Build usando Ubuntu + OpenJDK 21 + Maven
FROM ubuntu:latest AS build

ENV DEBIAN_FRONTEND=noninteractive

# Instala o JDK 21 (Adoptium) + Maven
RUN apt-get update && \
    apt-get install -y wget gnupg software-properties-common && \
    wget -O- https://packages.adoptium.net/artifactory/api/gpg/key/public | gpg --dearmor | tee /usr/share/keyrings/adoptium-archive-keyring.gpg > /dev/null && \
    add-apt-repository 'deb [signed-by=/usr/share/keyrings/adoptium-archive-keyring.gpg] https://packages.adoptium.net/artifactory/deb bookworm main' && \
    apt-get update && \
    apt-get install -y temurin-21-jdk maven

# Define diretório
WORKDIR /app

COPY . .

# Compila o projeto
RUN mvn clean install -DskipTests

# Etapa 2: Runtime com JDK 21
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia o JAR gerado (ajuste se o nome do .jar for outro)
COPY --from=build /app/target/deploy_render-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
