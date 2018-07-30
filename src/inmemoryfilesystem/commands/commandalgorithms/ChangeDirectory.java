package inmemoryfilesystem.commands.commandalgorithms;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.commands.contracts.CommandExecutable;
import inmemoryfilesystem.logic.DirectoryState;

import java.util.LinkedList;

public class ChangeDirectory implements CommandExecutable {
    @Override
    public void Execute(DirectoryState directoryState, Command command) {
        String path = command.getParameters().get(0);

        String[] pathParams = path.split("/");

        for (String param: pathParams) {
            if (param.equals(".")) continue;
            if (param.equals("..")){
                directoryState.goToParentDirectory();
            }
            else{
                directoryState.goToNextDirectory(param);
            }
        }
    }
}
