package io.khasang.teamnote.db.dao.impl;

import io.khasang.teamnote.db.ImplDaoFactory;
import io.khasang.teamnote.db.dao.CatDao;
import io.khasang.teamnote.model.Cat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gothmog on 28.07.2017.
 */
public class ImplCatDao implements CatDao {
    private static final Logger log = LoggerFactory.getLogger(ImplCatDao.class);
    private ImplDaoFactory daoFactory = new ImplDaoFactory();

    @Override
    public boolean createCat(Cat cat) {
        log.info("Create new cat");
        boolean result = false;
        String sql = "INSERT INTO public.cats(id, name) VALUES (?, ?)";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, cat.getId());
            preparedStatement.setString(2, cat.getName());

            int rowsInsert = preparedStatement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new cat was created successfully!");
                result = true;
            }
        } catch (SQLException | IOException ex){
            log.error("Error when creating new cat", ex);
        }
        return result;
    }

    @Override
    public boolean updateCat(int id, String name) {
        log.info("Update cat");
        boolean result = false;
        String sql = "UPDATE cats SET name = ? WHERE id = ?";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                log.info("An existing cat was updated successfully!");
                result = true;
            }
        } catch (SQLException | IOException ex){
            log.error("Error when update cat", ex);
        }
        return result;
    }

    @Override
    public void deleteCat(int id) {
        log.info("Delete user");
        String sql = "DELETE FROM cats WHERE id = ?";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                log.info("A cat was deleted successfully!");
            }
        } catch (SQLException | IOException ex){
            log.error("Error when delete cat", ex);
        }
    }

    @Override
    public List<Cat> getAllCats() {
        log.info("Get all cats");
        List<Cat> catList = new ArrayList<>();
        String sql = "SELECT * FROM cats ORDER BY name";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Cat cat = new Cat();
                cat.setId(resultSet.getInt("id"));
                cat.setName(resultSet.getString("name"));
                catList.add(cat);
            }
        } catch (SQLException | IOException ex){
            log.error("Error when getting all cats", ex);
        }
        return catList;
    }

    @Override
    public Cat getCatById(int id) {
        log.info("Read cat");
        Cat cat = new Cat();
        String sql = "SELECT * FROM cats WHERE id= ?";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            cat.setId(resultSet.getInt("id"));
            cat.setName(resultSet.getString("name"));
        } catch (SQLException | IOException ex){
            log.error("Error when reading cat's data", ex);
        }
        return cat;
    }
}
