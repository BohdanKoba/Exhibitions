package com.koba.exhibitions.web.command;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Holder for all commands.
 *
 * @author Bohdan Koba
 */
public class CommandContainer {
    private static final Logger log = Logger.getLogger(CommandContainer.class);

    private static final Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("signIn", new SignInCommand());
        commands.put("signOut", new SignOutCommand());
        commands.put("register", new RegistrationCommand());
        commands.put("setLanguage", new SetLanguageCommand());
        commands.put("exhibitions", new ExhibitionsCommand());
        commands.put("addToCart", new AddToCartCommand());
        commands.put("sortExhibitions", new SortExhibitionsCommand());
        commands.put("goTo", new goToCommand());

        log.debug("Command container was successfully initialized");
        log.trace("Number of commands --> " + commands.size());
    }

    /**
     * Returns a command object with the given name.
     *
     * @param commandName Name of the command.
     * @return Command object.
     */
    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            log.trace("Command not found, name --> " + commandName);
            // TODO redirect on Error404 page
            return commands.get("error404");
        }
        return commands.get(commandName);
    }


}
