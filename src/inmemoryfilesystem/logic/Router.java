package inmemoryfilesystem.logic;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.commands.Overload;
import inmemoryfilesystem.common.Validator;
import inmemoryfilesystem.users.UserState;

public class Router {

    private DirectoryState directoryState;
    private UserState userState;
    private Overload overload;

    public Router(DirectoryState directoryState, UserState userState) {
        Validator.checkIfNull(directoryState, directoryState.getClass().getName());
        Validator.checkIfNull(userState, userState.getClass().getName());

        this.directoryState = directoryState;
        this.userState = userState;
        this.overload = new Overload(directoryState);
    }

    public void processCommand(Command command) {
        Validator.checkIfNull(command, command.getClass().getName());

        this.overload.execute(command);

        // TODO: To implement user check logic.
    }
}