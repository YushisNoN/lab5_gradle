package lab5_gradle.interfaces;

import lab5_gradle.exceptions.NullValueException;

public interface Command {

    public String getDescription() throws NullValueException;

    public boolean getNeededArguments();

    public boolean getNeededCommands();

    public boolean getNeededCollections();

}
