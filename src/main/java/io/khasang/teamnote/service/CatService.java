package io.khasang.teamnote.service;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author gothmog on 25.07.2017.
 */
public class CatService {
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
            return "Error create:" + ex;
        }

    }

    /**
     * insert table
     *
     * @return data insert successful
     */
    public String insertCatTableStatus() {
        String sql = "INSERT INTO public.cats(id, name) VALUES (?, ?)";
        try {
            jdbcTemplate.update(sql, 1, "Barsik");
            jdbcTemplate.update(sql, 2, "Marsel");
            jdbcTemplate.update(sql, 3, "Funtik");
            jdbcTemplate.update(sql, 4, "Marselieza");
            return "data insert successful";
        } catch (Exception ex) {
            return "Error insert :" + ex;
        }

    }


    public String updateCatTableStatus() {
        String sql = "UPDATE cats SET name = ? WHERE id = ?";
        int id = 1;
        String name = "Bars";
        try {
            jdbcTemplate.update(sql, name, id);
            return "cats update successful";
        } catch (Exception ex) {
            return "Error update" + ex;
        }
    }

    /**
     * deleted table
     *
     * @return Table cats was deleted
     */
    public String deleteCatTableStatus() {
        String sql = "DROP TABLE IF EXISTS cats";
        try {
            jdbcTemplate.update(sql);
            return "Table cats was deleted";
        } catch (Exception ex) {
            return "Error deleted: " + ex;
        }
    }

    /**
     * Removal of cats by parameter
     *
     * @return was deleted
     */
    public String deleteCatsName() {
        String sql = "DELETE FROM cats WHERE name = ?";
        String name = "Bars";
        try {
            jdbcTemplate.update(sql, name);
            return "cat name = " + name + " was deleted!!!";
        } catch (Exception ex) {
            return "Error: " + ex;
        }
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
