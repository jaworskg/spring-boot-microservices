package jaworskg.microservices.configuration.basic.config;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ConditionalOnClass(Tomcat.class)
@ConditionalOnProperty(name = "log-tomcat-version", matchIfMissing = true)
public class TomcatLogConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(TomcatLogConfiguration.class);

    @PostConstruct
    public void logTomcatVersion() {
        LOGGER.info("\n\nTomcat version: " + Tomcat.class.getPackage().getImplementationVersion() + "\n\n");
    }

}
