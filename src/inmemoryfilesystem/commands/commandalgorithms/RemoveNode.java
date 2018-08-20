package inmemoryfilesystem.commands.commandalgorithms;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.commands.contracts.CommandExecutable;
import inmemoryfilesystem.common.Validator;
import inmemoryfilesystem.components.Directory;
import inmemoryfilesystem.logic.DirectoryState;

public class RemoveNode implements CommandExecutable {
    @Override
    public void execute(DirectoryState directoryState, Command command) {
        Validator.checkIfNull(directoryState, directoryState.getClass().getName());
        Validator.checkIfNull(command, command.getClass().getName());

        if (command.getParameters().isEmpty()){
            System.out.println("This command requires a parameter 'file name'.");

            return;
        }

        String name = command.getParameters().get(0);
        Directory thisDir = directoryState.getCurrentDirectory();

        boolean isDone = false;

        if (!command.getFlags().isEmpty()){
            if (command.getFlags().get(0) == "-R"){
                isDone = thisDir.deleteDirectoryRecursively(name) || thisDir.deleteFile(name);

            }
        }else {
            isDone = thisDir.deleteDirectory(name) || thisDir.deleteFile(name);
        }

        if (!isDone){
            System.out.println("There is no such file or folder.");
        }
    }

    @Override
    public String description() {
        return "Deletes file or folder. Use -R to remove recursively.";
    }
}
