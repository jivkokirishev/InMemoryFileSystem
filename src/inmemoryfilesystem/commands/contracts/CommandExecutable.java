package inmemoryfilesystem.commands.contracts;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.logic.DirectoryState;

public interface CommandExecutable {
    void execute(DirectoryState directoryState, Command command);

    String description();
}
