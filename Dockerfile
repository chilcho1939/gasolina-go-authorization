FROM amazoncorretto:8
ADD target/*.jar gasolina-go-usuarios.jar

EXPOSE 8586
ENTRYPOINT exec java -Dspring.profiles.active=docker -jar gasolina-go-usuarios.jar
