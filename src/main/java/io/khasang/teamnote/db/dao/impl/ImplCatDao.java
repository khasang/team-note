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
 * class implementation CRUD
 * @author gothmog on 28.07.2017.
 */
public class ImplCatDao implements CatDao {
    private static final Logger log = LoggerFactory.getLogger(ImplCatDao.class);
    private ImplDaoFactory daoFactory = new ImplDaoFactory();

    @Override
    public void createCat(Cat cat) {
        log.info("Create new cat");

        String sql = "INSERT INTO public.cats(id, name) VALUES (?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try  {
            connection = daoFactory.getConnection();
            preparedStatement =  connection.prepareStatement(sql);
            preparedStatement.setInt(1, cat.getId());
            preparedStatement.setString(2, cat.getName());

            int rowsInsert = preparedStatement.executeUpdate();
            if (rowsInsert != 0) {
                log.info("A new cat was created successfully!");
            }
        } catch (SQLException | IOException ex){
            log.error("Error when creating new cat", ex);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex){
                log.error("Error close ps connect", ex);
            }
        }
    }

    @Override
    public void updateCat(Cat cat) {
        log.info("Update cat");
        String sql = "UPDATE cats SET name = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cat.getName());
            preparedStatement.setInt(2,cat.getId());
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated != 0) {
                log.info("An existing cat was updated successfully!");
            }
        } catch (SQLException | IOException ex){
            log.error("Error when update cat", ex);
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex){
                log.error("Error close", ex);
            }
        }
    }

    @Override
    public void deleteCat(int id) {
        log.info("Delete user");
        String sql = "DELETE FROM cats WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
             connection = daoFactory.getConnection();
             preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted != 0) {
                log.info("A cat was deleted successfully!");
            }
        } catch (SQLException | IOException ex){
            log.error("Error when delete cat", ex);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex){
                log.error("Error close ps connect", ex);
            }
        }
    }

    @Override
    public List<Cat> getAllCats() {
        log.info("Get all cats");
        List<Cat> catList = new ArrayList<>();
        String sql = "SELECT * FROM cats ORDER BY name";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Cat cat = new Cat();
                cat.setId(resultSet.getInt("id"));
                cat.setName(resultSet.getString("name"));
                catList.add(cat);
            }
        } catch (SQLException | IOException ex){
            log.error("Error when getting all cats", ex);
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex){
                log.error("Error close rs, ps, connect", ex);
            }
        }
        return catList;
    }

    @Override
    public Cat getCatById(int id) {
        log.info("Read cat");
        String sql = "SELECT * FROM cats WHERE id= ?";
        Cat cat = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                cat = new Cat();
                cat.setId(id);
                cat.setName(resultSet.getString("name"));
                log.info("Cat Found: " + cat);
            } else {
                log.info("No Cat found with id = " + id);
            }
        } catch (SQLException | IOException ex){
            log.error("Error when reading cat's data", ex);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex){
                log.error("Error close resultset, preparestatement, connect", ex);
            }
        }
        return cat;
    }
}
