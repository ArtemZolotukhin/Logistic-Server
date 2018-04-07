package kpfu.logistic.server.config;

import kpfu.logistic.server.service.Crypter;
import kpfu.logistic.server.service.Md5Crypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"kpfu.logistic.server.service"})
@PropertySource({"classpath:/app.properties"})
public class ServiceConfig {


    @Autowired
    private Environment env;

    @Bean
    public Crypter crypter() {
        return new Md5Crypter(this.env.getProperty("crypter.soil"));
    }
}
