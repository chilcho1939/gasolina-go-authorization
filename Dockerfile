FROM amazoncorretto:8
ADD target/*.jar gasolina-go-authorization.jar

EXPOSE 8586
ENTRYPOINT exec java -Dspring.profiles.active=docker -jar gasolina-go-authorization.jar
