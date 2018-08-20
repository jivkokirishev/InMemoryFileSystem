package inmemoryfilesystem.commands.commandalgorithms;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.commands.contracts.CommandExecutable;
import inmemoryfilesystem.common.Validator;
import inmemoryfilesystem.logic.DirectoryState;


public class CreateFile implements CommandExecutable {
    @Override
    public void execute(DirectoryState directoryState, Command command) {
        Validator.checkIfNull(directoryState, directoryState.getClass().getName());
        Validator.checkIfNull(command, command.getClass().getName());

        String fileName = "";
        try {
            fileName = command.getParameters().get(0);
        }catch (IndexOutOfBoundsException e){
            System.out.println("This operation requires parameters to work. Please read how to use it in help section.");
            return;
        }


        String name = fileName;
        String ext = "";
        if(fileName.contains("\\.")){
            String[] nameAndExt = fileName.split("\\.");
            System.out.println(nameAndExt.length);
            name = nameAndExt[0];
            ext = nameAndExt[1];
        }

        String finalName = name;
        String finalExt = ext;
        if (directoryState.getCurrentDirectory().listAllFiles().stream().anyMatch(t -> (t.getName().equals(finalName) && t.getExtention().equals(finalExt)))){
            return;
        }

        directoryState.getCurrentDirectory().addFile(name, "", ext);
    }

    @Override
    public String description() {
        return "Creates a file.";
    }
}
