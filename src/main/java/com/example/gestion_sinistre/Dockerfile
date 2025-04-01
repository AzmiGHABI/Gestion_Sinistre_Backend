# Utilisation de l'image officielle OpenJDK
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le JAR dans l'image
COPY target/gestion-sinistre.jar app.jar

# Exposer le port utilisé par Spring Boot
EXPOSE 8098

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
