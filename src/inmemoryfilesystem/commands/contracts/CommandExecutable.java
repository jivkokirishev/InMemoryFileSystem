package inmemoryfilesystem.commands.contracts;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.logic.DirectoryState;

public interface CommandExecutable {
    void Execute(DirectoryState directoryState, Command command);
}
