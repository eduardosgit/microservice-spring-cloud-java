package br.com.estudo.springservice.testsupport;

import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

@Testcontainers
public abstract class BaseIntegrationTest {

    @Container
    static DockerComposeContainer<?> environment =
            new DockerComposeContainer<>(new File("src/test/resources/docker-compose.yml"))
                    .withExposedService("mysql", 3306);

    @BeforeAll
    static void setup() {
        String host = environment.getServiceHost("mysql", 3306);
        Integer port = environment.getServicePort("mysql", 3306);

        System.setProperty("spring.datasource.url",
                "jdbc:mysql://" + host + ":" + port + "/testdb?useSSL=false&allowPublicKeyRetrieval=true");
        System.setProperty("spring.datasource.username", "test");
        System.setProperty("spring.datasource.password", "test");
    }
}