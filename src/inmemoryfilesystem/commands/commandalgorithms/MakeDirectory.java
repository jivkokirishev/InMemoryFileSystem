package inmemoryfilesystem.commands.commandalgorithms;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.commands.contracts.CommandExecutable;
import inmemoryfilesystem.common.Validator;
import inmemoryfilesystem.logic.DirectoryState;

public class MakeDirectory implements CommandExecutable {
    @Override
    public void execute(DirectoryState directoryState, Command command) {
        Validator.checkIfNull(directoryState, directoryState.getClass().getName());
        Validator.checkIfNull(command, command.getClass().getName());

        String dirName = "";
        try {
            dirName = command.getParameters().get(0);
        }catch (IndexOutOfBoundsException e){
            System.out.println("This operation requires parameters to work. Please read how to use it in help section.");
            return;
        }

        directoryState.getCurrentDirectory().addDirectory(dirName);
    }

    @Override
    public String description() {
        return "Creates new directory in the current folder.";
    }
}
