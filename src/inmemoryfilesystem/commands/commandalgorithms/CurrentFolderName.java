package inmemoryfilesystem.commands.commandalgorithms;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.commands.contracts.CommandExecutable;
import inmemoryfilesystem.logic.DirectoryState;

public class CurrentFolderName implements CommandExecutable {
    @Override
    public void execute(DirectoryState directoryState, Command command) {
        System.out.println(directoryState.getCurrentDirectory().getName());
    }

    @Override
    public String description() {
        return "Writes current directory name.";
    }
}
