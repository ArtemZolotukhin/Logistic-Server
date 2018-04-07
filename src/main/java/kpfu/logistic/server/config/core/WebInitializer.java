package kpfu.logistic.server.config.core;

import kpfu.logistic.server.config.RootConfig;
import kpfu.logistic.server.config.WebConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class WebInitializer extends AbstractDispatcherServletInitializer {
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext cfg = new AnnotationConfigWebApplicationContext();
        cfg.register(WebConfig.class);
        return cfg;
    }

    /*
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(multipartConfigElement());
    }


    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("5242880");
        factory.setMaxRequestSize("5242880");
        factory.setLocation("/home/rz/tmp");
        return factory.createMultipartConfig();
    }

     */

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext cfg = new AnnotationConfigWebApplicationContext();
        cfg.register(RootConfig.class);
        return cfg;
    }
}
