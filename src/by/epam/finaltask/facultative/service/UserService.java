package by.epam.finaltask.facultative.service;

import by.epam.finaltask.facultative.dao.UserDAO;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.exception.ServiceException;

/**
 * Created by Admin on 19.04.2016.
 */
public class UserService {
    public final static User checkLogin(String login, String password) throws ServiceException{
        if (!Validator.loginValidator(login, password)){
            throw new ServiceException("Invalid login or password");
        }
        UserDAO userDAO = new UserDAO();
        try {
            User user =  userDAO.getUser(login,password);
            if (user!=null) {
                return user;
            }

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

        return null;
    }



    static class Validator{
        public static boolean loginValidator(String login, String password){
            if(login.isEmpty()){
                return false;
            }
            if(password.isEmpty()){
                return false;
            }
            return true;
        }
    }
}
