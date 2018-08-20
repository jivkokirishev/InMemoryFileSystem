package inmemoryfilesystem.logic;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.common.Validator;
import inmemoryfilesystem.users.UserState;

import java.util.LinkedList;
import java.util.List;

public class Handler {

    private Router router;

    public Handler(DirectoryState directoryState, UserState userState) {
        Validator.checkIfNull(directoryState, directoryState.getClass().getName());
        Validator.checkIfNull(userState, userState.getClass().getName());

        this.router = new Router(directoryState, userState);
    }

    public Handler(Router router) {
        Validator.checkIfNull(router, router.getClass().getName());

        this.router = router;
    }

    public void parseCommandLine(String line){
        Validator.checkIfNullOrEmpty(line);

        String[] args = line.split(" ");

        String name = args[0];
        List<String> parameters = new LinkedList<>();
        List<String> flags = new LinkedList<>();

        for (int i = 1; i < args.length; i++){
            if(args[i].contains("-")){
                flags.add(args[i]);
            }
            else { parameters.add(args[i]); }
        }

        Command command = new Command(name, parameters, flags);
        this.router.processCommand(command);
    }
}
