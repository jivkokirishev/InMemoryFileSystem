package inmemoryfilesystem.commands.commandalgorithms;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.commands.contracts.CommandExecutable;
import inmemoryfilesystem.common.Validator;
import inmemoryfilesystem.components.Directory;
import inmemoryfilesystem.components.File;
import inmemoryfilesystem.logic.DirectoryState;

public class ListChildren implements CommandExecutable {
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";

    @Override
    public void execute(DirectoryState directoryState, Command command) {
        Validator.checkIfNull(directoryState, directoryState.getClass().getName());
        Validator.checkIfNull(command, command.getClass().getName());

        for (File file : directoryState.getCurrentDirectory().listAllFiles()) {
            System.out.print(ANSI_BLUE);
            if (!file.getExtention().isEmpty()){
                StringBuilder fullName = new StringBuilder();
                fullName.append(file.getName())
                        .append(".")
                        .append(file.getExtention())
                        .append("  ")
                        .append(ANSI_RESET);
                System.out.print(fullName.toString());
            }else { System.out.print(file.getName() + "  " + ANSI_RESET); }
        }

        for (Directory dir : directoryState.getCurrentDirectory().listAllDirectories()) {
            System.out.print(dir.getName() + "  ");
        }

        System.out.println();
    }

    @Override
    public String description() {
        return "List all directories and files in the current directory.";
    }
}
