package inmemoryfilesystem.commands;

import inmemoryfilesystem.commands.commandalgorithms.*;
import inmemoryfilesystem.commands.contracts.CommandExecutable;
import inmemoryfilesystem.common.Validator;
import inmemoryfilesystem.logic.DirectoryState;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Overload {

    private DirectoryState directoryState;
    private Map<String, CommandExecutable> commandAlgorithms;

    public Overload(DirectoryState directoryState){
        Validator.checkIfNull(directoryState, directoryState.getClass().getName());

        this.directoryState = directoryState;
        this.commandAlgorithms = new HashMap<>();

        this.loadCommands();
    }

    private void loadCommands(){
        this.commandAlgorithms.put("pwd", new CurrentFolderName());
        this.commandAlgorithms.put("cd", new ChangeDirectory());
        this.commandAlgorithms.put("ls", new ListChildren());
        this.commandAlgorithms.put("mkdir", new MakeDirectory());
        this.commandAlgorithms.put("touch", new CreateFile());
        this.commandAlgorithms.put("cat", new EditViewContent());
        this.commandAlgorithms.put("rm", new RemoveNode());
        this.commandAlgorithms.put("exit", new ExitFileSystem());

    }

    public void execute(Command command){
        Validator.checkIfNull(command, command.getClass().getName());

        if (command.getName().equals("help")){
            List<String> parameters = command.getParameters();
            if (parameters.size() > 0){
                System.out.print(parameters.get(0) + ":  ");
                System.out.println(this.commandAlgorithms.get(parameters.get(0)).description());
            } else {
                for (Map.Entry<String, CommandExecutable> algorithm : this.commandAlgorithms.entrySet()) {
                    System.out.println(String.format("%s:  %s", algorithm.getKey(), algorithm.getValue().description()));
                }
            }
        } else {
            if (!this.commandAlgorithms.containsKey(command.getName())){
                System.out.println("There is no such command.");
                return;
            }
            this.commandAlgorithms.get(command.getName()).execute(this.directoryState, command);
        }

    }
}
