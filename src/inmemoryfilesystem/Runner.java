package inmemoryfilesystem;

import inmemoryfilesystem.logic.DirectoryState;
import inmemoryfilesystem.logic.Handler;
import inmemoryfilesystem.logic.Router;
import inmemoryfilesystem.users.UserState;

import java.util.Scanner;

public class Runner {
    private Handler handler;
    private DirectoryState directoryState;
    private UserState userState;

    public Runner(String rootDirectory){
        this.userState = new UserState();
        this.directoryState = new DirectoryState(rootDirectory, this.userState.getCurrentUser());
        this.handler = new Handler(new Router(this.directoryState, this.userState));
    }

    public void run(){
        this.directoryState.setIsRunning(true);
        System.out.println("File system created!");

        Scanner input = new Scanner(System.in);
        while (this.directoryState.getIsRunning()){
            System.out.print(this.directoryState.getRawDirectoryPath() + "  ");
            String commandLine = input.nextLine();
            this.handler.parseCommandLine(commandLine);
        }
    }
}
