package by.epam.finaltask.facultative.controller;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.helper.*;
import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 19.04.2016.
 */
public class Controller extends HttpServlet {
        private static final long serialVersionUID = 1L;

        private static final String COMMAND_NAME = "command";

        private final CommandHelp commandHelper = new CommandHelp();

        public Controller() {
            super();
        }

        @Override
        protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
            // TODO Auto-generated method stub
            super.service(arg0, arg1);
        }
    @Override
    public void init(){
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            connectionPool.initPoolData();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
    }
     public void destroy(){
         ConnectionPool connectionPool = ConnectionPool.getInstance();
         connectionPool.dispose();
     }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = null;
        Command command = null;
        String page = null;
        try{
            commandName = request.getParameter(COMMAND_NAME);
            command = commandHelper.getCommand(commandName);
            page = command.execute(request);
        }catch(CommandException e){
            page = PageName.ERROR_PAGE;
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        if (dispatcher != null){
            dispatcher.forward(request, response);
        }else{
            // to do
        }

    }


}
