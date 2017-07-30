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

    public String createNewBookCharacter(String name, String order) {
        String query = String.format(
                "INSERT INTO \"books\".\"book_heroes\" (name, \"order\") VALUES ('%s' ,'%s');", name, order);
        jdbcTemplate.execute(query);
        return "done";
    }

    public String updateBookCharacter(int id, String name, String order) {
        String query = String.format(
                "UPDATE \"books\".\"book_heroes\" SET name = '%s', \"order\" = '%s' WHERE id = %d;", name, order, id);
        jdbcTemplate.execute(query);
        return "done";
    }

    public String deleteBookCharacter(int id) {
        String query = String.format(
                "DELETE FROM \"books\".\"book_heroes\" WHERE id = %d;", id);
        jdbcTemplate.execute(query);
        return "done";
    }
}
