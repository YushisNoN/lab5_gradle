package lab5_gradle.utility;

import java.util.HashMap;
import lab5_gradle.interfaces.Executable;

public class CommandManager {
    protected HashMap<String, Executable> commandsMap = new HashMap<>();

    public HashMap<String, Executable> getCommandsList() {
        return commandsMap;
    }

    public void addCommand(Executable command) {
        commandsMap.put(command.toString(), command);
    }

}
