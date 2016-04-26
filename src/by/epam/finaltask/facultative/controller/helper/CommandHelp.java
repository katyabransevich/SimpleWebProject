package by.epam.finaltask.facultative.controller.helper;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.CommandName;
import by.epam.finaltask.facultative.command.impl.LoginCommand;
import by.epam.finaltask.facultative.command.impl.UnknownCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 19.04.2016.
 */
public class CommandHelp {
    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandHelp(){

        commands.put(CommandName.LOGIN, new LoginCommand());

    }


    public Command getCommand(String commandName){
        Command command = null;
        CommandName key = null;

        commandName = commandName.replace('-', '_').toUpperCase();
        key = CommandName.valueOf(commandName);

        command = commands.get(key);

        if(command == null){
            command =  new UnknownCommand();
        }

        return command;
    }

}
