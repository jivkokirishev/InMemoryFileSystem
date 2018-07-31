package inmemoryfilesystem.logic;

import inmemoryfilesystem.commands.Command;

import java.util.LinkedList;
import java.util.List;

public class Handler {

    private Router router;

    public Handler(DirectoryState directoryState) {
        this.router = new Router(directoryState);
    }

    public Handler(Router router) {
        this.router = router;
    }

    public void parseCommandLine(String line){

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
