package io.khasang.teamnote.service;


import org.springframework.jdbc.core.JdbcTemplate;

public class CatService {
    private JdbcTemplate jdbcTemplate;

    public CatService() {
    }

    public CatService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createCatTableStatus(){
        jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
        jdbcTemplate.execute("CREATE TABLE cats (\n"+
                "id INTEGER CONSTRAINT firstkay PRIMARY KEY , \n" +
                "name VARCHAR (255) NOT NULL );");
        return "table created";
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
