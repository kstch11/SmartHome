package house.commands;

/**
 * Represents an action that can be done between house subjects/objects.
 */
public interface Command {

    /**
     * Executes the action.
     */
    void execute();
}
