package inmemoryfilesystem.commands;

import inmemoryfilesystem.commands.commandalgorithms.ChangeDirectory;
import inmemoryfilesystem.commands.commandalgorithms.ListChildren;
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
        commandAlgorithms.put("cd", new ChangeDirectory());
        commandAlgorithms.put("ls", new ListChildren());
    }

    public void Execute(Command command){
        this.commandAlgorithms.get(command.getName()).Execute(this.directoryState, command);
    }
}
