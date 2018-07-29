package inmemoryfilesystem.commands;

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
    }
}
