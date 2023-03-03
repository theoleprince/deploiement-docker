# la premier etape de contruction utilisera une image parent de maven 3.6.1
FROM maven:3.6.1-alpine AS MAVEN_BUILD

# copier le code pom et src dans le conteneur
COPY ./ ./

# package le code de notre application
RUN mvn clean package -DskipTests

# la deuxieme etape de construction utilisera open tomcat
FROM tomcat:8.0.51-jre8-alpine

# changer le port interne du conteneur tomcat
RUN value=`cat conf/server.xml` && echo "${value//8080/80}" >| conf/server.xml

# ne copier que les artefacts dont on a besoin depuis la premiere etape et ignore le reste
COPY --from=MAVEN_BUILD ./target/*.war /usr/local/tomcat/webapps/tp1.war

EXPOSE 80

# CMD ["java", "-jar", "/tp1.jar"] 

CMD ["catalina.sh", "run"]


# Copiez l'exécutable dans le conteneur à /app
# ADD target/*.jar app.jar

# Rendre le port 8085 accessible au monde en dehors de ce conteneur
# EXPOSE 8085

# definir la commande de demarrage pour executer le jar
# CMD ["java", "-jar", "/demo.jar"] 


# # Utiliser un runtime OpenJDK comme image parent
# FROM openjdk:8-jre-alpine
# # Définir les variables d'environnement
# ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \JAVA_OPTS=""
# # Définissez le répertoire de travail sur /app
# WORKDIR /app
# # Copiez l'exécutable dans le conteneur à /app
# ADD target/*.jar app.jar
# # Rendre le port 8080 accessible au monde en dehors de ce conteneur
# EXPOSE 8085
# # Exécutez app.jar au lancement du conteneur
# CMD ["java", "-jar", "/app/app.jar"] 


# # Utiliser un runtime OpenJDK comme image parent
# FROM openjdk:8-jdk-alpine

# # Ajouter des informations sur le responsable
# LABEL maintainer="Progressive Coder"

# # Ajouter un volume temporaire
# VOLUME /tmp

# # Rendre le port 8080 accessible au monde en dehors de ce conteneur
# EXPOSE 8080

# # Fichier Jar d'application
# ARG JAR_FILE=target/tp1-0.0.1-SNAPSHOT.jar

# # Ajouter le fichier Jar d'application au conteneur
# ADD ${JAR_FILE} app.jar

# # Exécuter le fichier JAR
# CMD ["java", "-jar", "/app.jar"]