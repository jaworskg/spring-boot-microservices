package jaworskg.microservices.configuration.basic;

import jaworskg.microservices.configuration.basic.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ConfigurationBasicApplication {

    @Value("${application.projectName}")
    void displayProjectName(String projectName) {
        System.out.println("Project name (value annotation): " + projectName);
    }

    @Autowired
    void displayProjectName(Environment environment) {
        System.out.println("Project name (environment object): " + environment.getProperty("application.projectName"));
    }

    @Autowired
    void displayProjectName(ApplicationProperties applicationProperties) {
        System.out.println("Project name (configuration properties): " + applicationProperties.getProjectName());
    }

    public static void main(String... args) {
        SpringApplication.run(ConfigurationBasicApplication.class, args);
    }

}
