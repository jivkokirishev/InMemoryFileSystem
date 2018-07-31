package inmemoryfilesystem.logic;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.commands.Overload;

public class Router {

    private DirectoryState directoryState;
    private Overload overload;

    public Router(DirectoryState directoryState) {
        this.directoryState = directoryState;
        this.overload = new Overload(directoryState);
    }

    public void processCommand(Command command){
        this.overload.execute(command);
    }
}
