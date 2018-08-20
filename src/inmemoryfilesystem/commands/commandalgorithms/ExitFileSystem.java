package inmemoryfilesystem.commands.commandalgorithms;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.commands.contracts.CommandExecutable;
import inmemoryfilesystem.common.Validator;
import inmemoryfilesystem.logic.DirectoryState;

public class ExitFileSystem implements CommandExecutable {
    @Override
    public void execute(DirectoryState directoryState, Command command) {
        Validator.checkIfNull(directoryState, directoryState.getClass().getName());
        Validator.checkIfNull(command, command.getClass().getName());

        directoryState.setIsRunning(false);
    }

    @Override
    public String description() {
        return "Exits the file system. All files will be erased!";
    }
}
