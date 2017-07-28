package io.khasang.teamnote.service;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookService {
    private JdbcTemplate jdbcTemplate;

    public BookService() {
    }

    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createNewBookCharacter() {
        jdbcTemplate.execute("INSERT INTO \"Users\".\"Superheroes\" (name, nickname) VALUES ('Kaladin' ,'Stormblessed');");
        return "done";
    }
}
