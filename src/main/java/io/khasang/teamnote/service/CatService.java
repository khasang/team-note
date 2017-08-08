package io.khasang.teamnote.service;

import io.khasang.teamnote.model.Cat;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

//@Repository
public class CatService {
    private JdbcTemplate jdbcTemplate;

    private static final String insertSql =
        "INSERT INTO cats (" +
                "id, " +
                "name) " +
                "VALUES (?, ?)";

    private static final String updateSql =
            "UPDATE cats " +
                    "SET name = ? " +
                    "WHERE id = ?";

    private static final String deleteSql =
            "DELETE FROM cats " +
                    "WHERE id = ?";


    public CatService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CatService() {
    }

    public String createCatTableStatus(){
        //Два разных подключения, две разные сессии
        jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
        jdbcTemplate.execute("CREATE TABLE cats (\n" +
                "id INTEGER CONSTRAINT cat_key PRIMARY KEY , \n" +
                "name VARCHAR (255) NOT NULL);");
        return  "table Created";
    }

    public String incertLine(Cat cat) {
        jdbcTemplate.update(insertSql, cat.getId(), cat.getName());
        return  "id: " + cat.getId() + ", name: " + cat.getName();
    }

    public String incertLine(int id, String name){
        jdbcTemplate.update(insertSql, id, name);
        return  "id: " + id + ", name: " + name;
    }

    public String updateById(Cat cat){
        jdbcTemplate.update(updateSql, cat.getName(), cat.getId());
        return  "where id: " + cat.getId();
    }

    public String deleteById(int id){
        jdbcTemplate.update(deleteSql, id);
        return  "where id: " + id;
    }

    public String joinCatCompanies(){
        List<Map<String, Object>> list =
                jdbcTemplate.queryForList(
                "SELECT * " +
                        "FROM cats FULL OUTER JOIN companies " +
                        "ON cats.id = companies.id;");

        StringJoiner res = new StringJoiner("|||");
        for(Map<String, Object> map: list){
            StringJoiner line = new StringJoiner("|");
            for(Map.Entry<String, Object> entry: map.entrySet()){
                line.add(entry.toString());
            }
            res.add(line.toString());
        }
        return  res.toString();
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
