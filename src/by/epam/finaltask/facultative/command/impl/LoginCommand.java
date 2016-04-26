package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.UserService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 19.04.2016.
 */
public class LoginCommand implements Command {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page;
        try {
            User user = UserService.checkLogin(request.getParameter(LOGIN), request.getParameter(PASSWORD));
            if (user != null){
                request.getSession(true).setAttribute(LOGIN, user);
                page = PageName.USER_PAGE;
            }else{
                page = PageName.ERROR_PAGE;
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return page;
    }

}
