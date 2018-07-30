package inmemoryfilesystem.logic;

public class Handler {

    private Router router;

    public Handler(DirectoryState directoryState) {
        this.router = new Router(directoryState);
    }

    public Handler(Router router) {
        this.router = router;
    }

    public void parseCommandLine(String line){

        //TODO: This method should divide the input into command name, parameters and flags, then to create command object and parse it to the router.
        //this.router.processCommand();
    }
}
