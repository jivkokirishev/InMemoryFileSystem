package inmemoryfilesystem;

import inmemoryfilesystem.logic.DirectoryState;
import inmemoryfilesystem.logic.Handler;
import inmemoryfilesystem.logic.Router;

import java.util.Scanner;

public class Runner {
    private Handler handler;
    private DirectoryState directoryState;
    public Runner(String rootDirectory){
        this.directoryState = new DirectoryState(rootDirectory);
        this.handler = new Handler(new Router(this.directoryState));
    }

    public void run(){
        System.out.println("File system created!");

        Scanner input = new Scanner(System.in);
        while (true){
            System.out.print(this.directoryState.getRawDirectoryPath() + "  ");
            String commandLine = input.nextLine();
            this.handler.parseCommandLine(commandLine);
        }
    }
}
