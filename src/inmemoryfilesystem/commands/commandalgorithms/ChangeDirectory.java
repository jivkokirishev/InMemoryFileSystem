package inmemoryfilesystem.commands.commandalgorithms;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.commands.contracts.CommandExecutable;
import inmemoryfilesystem.common.Validator;
import inmemoryfilesystem.logic.DirectoryState;

import java.security.InvalidParameterException;

public class ChangeDirectory implements CommandExecutable {
    @Override
    public void execute(DirectoryState directoryState, Command command) {
        Validator.checkIfNull(directoryState, directoryState.getClass().getName());
        Validator.checkIfNull(command, command.getClass().getName());

        String path = "";
        try {
            path = command.getParameters().get(0);
        }catch (IndexOutOfBoundsException e){
            System.out.println("There is not any path.");
            return;
        }

        String[] pathParams = path.split("/");

        if (pathParams.length < 1){
            System.out.println("The path is not correct.");
            return;
        }

        for (String param: pathParams) {
            if (param.equals(".") || param.equals("")) continue;
            if (param.equals("..")){
                directoryState.goToParentDirectory();
            }
            else if (param.equals("~")){
                while (directoryState.getCurrentDirectoryPath().size() != 1){
                    directoryState.goToParentDirectory();
                }
            }
            else{
                try {
                    directoryState.goToNextDirectory(param);
                }catch (InvalidParameterException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    @Override
    public String description() {
        return "This command changes the current directory. " +
                "You can move forward by typing a children folder name or path. For moving backwards type '..'. " +
                "If you want to go to the root folder, you can write '~'.";
    }
}
