import inmemoryfilesystem.Runner;

public class Launcher {
    public static void main(String[] args){
        Runner fileSystem = new Runner("/");
        fileSystem.run();
    }
}
