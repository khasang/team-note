package io.khasang.teamnote.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:hibernate.properties")
public class HibernateConfig {
    private final Environment environment;

    @Autowired
    public HibernateConfig(Environment environment) {
        this.environment = environment;
    }

    //Для подключения к БД
    @Bean
    DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("hibernate.driver"));
        dataSource.setUrl(            environment.getRequiredProperty("hibernate.url"));
        dataSource.setUsername(       environment.getRequiredProperty("hibernate.name"));
        dataSource.setPassword(       environment.getRequiredProperty("hibernate.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("io.khasang.teamnote.entity");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect"     , environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql"    , environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql"  , environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("show_sql"              , environment.getRequiredProperty("hibernate.show_sql"));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager (SessionFactory s){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(s);
        return transactionManager;
    }
}
