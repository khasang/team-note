package io.khasang.teamnote.service;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author gothmog on 25.07.2017.
 */

public class CatService {
    //private static final Logger logger = LoggerFactory.getLogger(CatService.class);
    private JdbcTemplate jdbcTemplate;

    public CatService() {
    }

    public CatService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * create table
     *
     * @return string table created successful
     */
    public String createCatTableStatus() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
            jdbcTemplate.execute("CREATE TABLE cats(\n" +
                    "id INTEGER CONSTRAINT cat_pk PRIMARY KEY ,\n" +
                    "name VARCHAR (255) NOT NULL );");
            return "table created successful";
        } catch (Exception ex) {
            return "Error:" + ex;
        }

    }

    /**
     * insert table
     *
     * @return data insert successful
     */
    public String insertCatTableStatus() {
        jdbcTemplate.update("");
        jdbcTemplate.update("");
        return "data insert successful";
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
