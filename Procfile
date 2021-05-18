web: java -jar target/user-1.0.jar
release: ./mvnw flyway:migrate
release: java -cp target/classes/:target/dependency/* com.zillennium.secretary.user.Migrations
