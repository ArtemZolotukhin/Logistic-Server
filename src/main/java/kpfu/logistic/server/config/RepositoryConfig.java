package kpfu.logistic.server.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@EnableJpaRepositories(basePackages = {"kpfu.logistic.server.repository"})
@ComponentScan({"kpfu.logistic.server.repository"})
@PropertySource({"classpath:/app.properties"})
public class RepositoryConfig {

    @Autowired
    private Environment env;


    public RepositoryConfig() {
    }

    @Bean
    public DataSource dataSource() {
        if (!env.getProperty("jdbc.is_local").equals("true")) {

            try {
                String driver = this.env.getProperty("jdbc.driver");
                //Load driver
                Class.forName(driver);

                URI dbUri = new URI(this.env.getProperty("jdbc.uri_remote"));

                String username = dbUri.getUserInfo().split(":")[0];
                String password = dbUri.getUserInfo().split(":")[1];
                String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

                DriverManagerDataSource dataSource = new DriverManagerDataSource();
                dataSource.setUrl(dbUrl);
                dataSource.setUsername(username);
                dataSource.setPassword(password);
                dataSource.setDriverClassName(driver);

                return dataSource;
            } catch (URISyntaxException | ClassNotFoundException ex) {
                Logger.getLogger(RootConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            String driver = this.env.getProperty("jdbc.driver");
            try {
                //Load driver
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RootConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
            dataSource.setDriverClassName(this.env.getProperty("jdbc.driver"));
            dataSource.setUrl(this.env.getProperty("jdbc.uri_local"));
            dataSource.setUsername(this.env.getProperty("db.user_local"));
            dataSource.setPassword(this.env.getProperty("db.password_local"));
            return dataSource;
        }
        return null;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(this.dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(new String[]{this.env.getRequiredProperty("entitymanager.packages.to.scan")});
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactoryBean.setJpaProperties(this.getHibernateProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(this.entityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", this.env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", this.env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", this.env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.enable_lazy_load_no_trans", this.env.getRequiredProperty("hibernate.enable_lazy_load_no_trans"));
        return properties;
    }
}
