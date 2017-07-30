package io.khasang.teamnote.config;

import io.khasang.teamnote.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
@PropertySource(value = "classpath:properties/jdbc.properties")
@PropertySource(value="classpath:properties/auth.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driver"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        return dataSource;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource());
        jdbcDao.setUsersByUsernameQuery(environment.getRequiredProperty("usersByQuery"));
        jdbcDao.setAuthoritiesByUsernameQuery(environment.getRequiredProperty("rolesByQuery"));
        return jdbcDao;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    CatService catService(){
        return new CatService(jdbcTemplate());
    }
}
