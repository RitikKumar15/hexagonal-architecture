FROM amazoncorretto:17-alpine-jdk
EXPOSE 9090
COPY target/hexagonal-pattern.jar hexagonal-pattern.jar
ENTRYPOINT ["java","-jar","hexagonal-pattern.jar"]