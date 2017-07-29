package io.khasang.teamnote.config;

import io.khasang.teamnote.db.dao.impl.ImplCatDao;
import io.khasang.teamnote.model.BackupTable;
import io.khasang.teamnote.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author gothmog on 25.07.2017.
 */
@Configuration
@PropertySource(value = {"classpath:util.properties"})
@PropertySource(value = {"classpath:backup.properties"})
public class AppConfig {

    private Environment environment;

    @Autowired
    public AppConfig(Environment environment) {
        this.environment = environment;
    }

    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.postgresql.driverClass"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public CatService catService() {
        return new CatService(jdbcTemplate());
    }

    @Bean
    public ImplCatDao implCatDao(){
        return new ImplCatDao();
    }

    @Bean
    public BackupTable backupTable(){
        return new BackupTable();
    }



}
