package ua.busstation.web.command;

import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;


/**
 * Holder for all commands.<br/>
 * 
 * @author O.Soklakov
 * 
 */
public class CommandContainer {
	
private static final Logger log = Logger.getLogger(CommandContainer.class);
	
	private static Map<String, Command> commands = new TreeMap<String, Command>();
	
	static {
		// common commands
		commands.put("login", new LoginCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("noCommand", new NoCommand());
		commands.put("registration", new RegistrationCommand());
		commands.put("viewRegistration", new ViewRegistrationCommand());
		commands.put("confirmRegistration", new ConfirmRegistrationCommand());
		
		// client commands
		commands.put("routes", new ListRoutesCommand());
		commands.put("buses", new ListBusCommand());
		commands.put("reckoning", new ReckoningCommand());
		
		// admin commands
		commands.put("users", new ListUsersCommand());
		commands.put("viewEditUser", new ViewEditUserCommand());
		commands.put("editUser", new EditUserCommand());
		commands.put("deleteUser", new DeleteUserCommand());
		
		log.debug("Command container was successfully initialized");
		log.trace("Number of commands --> " + commands.size());
	}

	/**
	 * Returns command object with the given name.
	 * 
	 * @param commandName
	 *            Name of the command.
	 * @return Command object.
	 */
	public static Command get(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			log.trace("Command not found, name --> " + commandName);
			return commands.get("noCommand"); 
		}
		
		return commands.get(commandName);
	}

}
