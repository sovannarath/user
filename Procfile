web: java -Dserver.port=$PORT -jar target/*.jar
release: ./mvnw flyway:migrate
release: java -cp target/classes/:target/dependency/* com.zillennium.secretary.user.Migrations
