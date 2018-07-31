package inmemoryfilesystem.commands.commandalgorithms;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.commands.contracts.CommandExecutable;
import inmemoryfilesystem.logic.DirectoryState;

public class MakeDirectory implements CommandExecutable {
    @Override
    public void execute(DirectoryState directoryState, Command command) {

        String dirName = command.getParameters().get(0);
        directoryState.getCurrentDirectory().addDirectory(dirName);
    }

    @Override
    public String description() {
        return "Creates new directory in the current folder.";
    }
}
