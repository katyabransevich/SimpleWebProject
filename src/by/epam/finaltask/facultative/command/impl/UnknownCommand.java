package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 19.04.2016.
 */
public class UnknownCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return null;
    }
}
