package io.khasang.teamnote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:properties/jdbc.query.properties")
public class CatService {
    @Autowired
    private Environment environment;

    private JdbcTemplate jdbcTemplate;

    public CatService() {
    }

    public CatService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createTable() {
        jdbcTemplate.execute(environment.getProperty("query.dropTable"));
        jdbcTemplate.execute(environment.getProperty("query.createTable"));
        return "Table has created";
    }

    public String insertValue() {
        jdbcTemplate.execute(environment.getProperty("query.insertIntoTable"));
        return "Barsik has added";
    }

    public String updateValue() {
        jdbcTemplate.execute(environment.getProperty("query.updateTable"));
        return "Muska has changed Barsik";
    }

    public String deleteValue() {
        jdbcTemplate.execute(environment.getProperty("query.deleteFromTable"));
        return "value deleted";
    }


}
