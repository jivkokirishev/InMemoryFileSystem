import inmemoryfilesystem.Runner;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args){
        Runner fileSystem = new Runner("/");
        fileSystem.run();
    }
}
