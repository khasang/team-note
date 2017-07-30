package io.khasang.teamnote.config;

import io.khasang.teamnote.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = ("classpath:util/properties"))
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(environment.getProperty("jdbc.postgresql.driver"));
        driverManagerDataSource.setUrl(environment.getProperty("jdbc.postgresql.url"));
        driverManagerDataSource.setUsername(environment.getProperty("jdbc.postgresql.username"));
        driverManagerDataSource.setPassword(environment.getProperty("jdbc.postgresql.password"));
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public BookService bookService() {
        return new BookService(jdbcTemplate());
    }
}
