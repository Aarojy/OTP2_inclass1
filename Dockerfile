FROM maven:latest
LABEL authors="aaroj"

WORKDIR /app
COPY pom.xml /app
COPY . /app
RUN mvn package
CMD ["java", "-jar", "target/OTP2_inclass1-1.0-SNAPSHOT.jar"]