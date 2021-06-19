package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.controller.command.exception.CommandNotFoundException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Holder for all commands.
 */
public class CommandContainer {
    private static final Logger log = LogManager.getLogger(CommandContainer.class);

    private static final Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("signIn", new SignInCommand());
        commands.put("signOut", new SignOutCommand());
        commands.put("register", new RegistrationCommand());
        commands.put("setLanguage", new SetLanguageCommand());
        commands.put("getExhibitions", new GetExhibitionsCommand());
        commands.put("sortExhibitions", new SortExhibitionsCommand());
//        commands.put("changeStatus", new ChangeStatusCommand(service));
        commands.put("addExhibition", new AddExhibitionCommand());
        commands.put("buyTickets", new BuyTicketsCommand());
        commands.put("getOrderExhibition", new GetOrderExhibition());
        commands.put("getAccountOrders", new GetAccountOrdersCommand());
        commands.put("filterExhibitions", new FilterExhibitionsCommand());

        log.debug("Command container was successfully initialized");
        log.trace("Number of commands --> " + commands.size());
    }

    /**
     * Returns a command object with the given name.
     *
     * @param commandName Name of the command.
     * @return <code>Command</code> object.
     */
    public static Command get(String commandName) throws CommandNotFoundException {
        if (commandName == null || !commands.containsKey(commandName)) {
            throw new CommandNotFoundException("Command not found, name --> " + commandName);
        }
        return commands.get(commandName);
    }

}
