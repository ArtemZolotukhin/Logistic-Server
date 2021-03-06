package kpfu.logistic.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RepositoryConfig.class, ServiceConfig.class, ValidatorConfig.class})
public class RootConfig {
}
