package by.epam.finaltask.facultative.dao;

import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.User;

import java.sql.*;

/**
 * Created by Admin on 25.04.2016.
 */
public class UserDAO {

    public User getUser(String login, String password) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        Statement st=null;
        ResultSet rs=null;
      User user= new User();
        try {
            connection = connectionPool.takeConnection();
            String sql =  "SELECT login, password FROM autent WHERE login='"+login+"' AND password='"+password+"';";
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                user.setLogin(rs.getString(1));
                user.setPassword(rs.getString(2));
                return  user;
            }

       } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection,st,rs);
        }
        return null;

    }
}