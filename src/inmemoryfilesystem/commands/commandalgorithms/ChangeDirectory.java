package inmemoryfilesystem.commands.commandalgorithms;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.commands.contracts.CommandExecutable;
import inmemoryfilesystem.logic.DirectoryState;

import java.util.LinkedList;

public class ChangeDirectory implements CommandExecutable {
    @Override
    public void execute(DirectoryState directoryState, Command command) {
        String path = command.getParameters().get(0);

        String[] pathParams = path.split("/");

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
                directoryState.goToNextDirectory(param);
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
