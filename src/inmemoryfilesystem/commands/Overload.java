package inmemoryfilesystem.commands;

import inmemoryfilesystem.commands.commandalgorithms.*;
import inmemoryfilesystem.commands.contracts.CommandExecutable;
import inmemoryfilesystem.logic.DirectoryState;

import java.util.HashMap;
import java.util.Map;

public class Overload {

    private DirectoryState directoryState;
    private Map<String, CommandExecutable> commandAlgorithms;

    public Overload(DirectoryState directoryState){
        this.directoryState = directoryState;
        this.commandAlgorithms = new HashMap<>();

        this.loadCommands();
    }

    private void loadCommands(){
        commandAlgorithms.put("pwd", new CurrentFolderName());
        commandAlgorithms.put("cd", new ChangeDirectory());
        commandAlgorithms.put("ls", new ListChildren());
        commandAlgorithms.put("mkdir", new MakeDirectory());
        commandAlgorithms.put("touch", new CreateFile());
        commandAlgorithms.put("cat", new EditViewContent());
    }

    public void execute(Command command){
        this.commandAlgorithms.get(command.getName()).execute(this.directoryState, command);
    }
}
