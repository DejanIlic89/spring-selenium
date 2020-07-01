# spring-selenium

Do the packaging first:

``mvn clean package -DskipTests``

Navigate to target directory:

``cd target/``

Run tests with command:

``java -cp spring-boot-selenium.jar:spring-boot-selenium-tests.jar:libs/* -Dbrowser=chrome -Dspring.profiles.active=remote io.cucumber.core.cli.Main classpath:features --glue com.demo.spring.springselenium.bdd --add-plugin html:test-output/ --threads 2``
