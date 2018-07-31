package inmemoryfilesystem.logic;

import inmemoryfilesystem.components.Directory;

import java.util.*;
import java.util.stream.Collectors;

public class DirectoryState {

    private String rootDirectory;
    private String rawDirectoryPath;
    private Directory currentDirectory;
    private List<String> currentDirectoryPath;

    public DirectoryState(String rootDirectory) {
        this.rootDirectory = rootDirectory;
        this.rawDirectoryPath = rootDirectory;
        this.currentDirectoryPath = new LinkedList<>();
        this.currentDirectoryPath.add("/");
        this.currentDirectory = new Directory(rootDirectory, null);
    }

    public void goToParentDirectory(){
        String dirName = this.currentDirectory.getName();

        if (this.currentDirectoryPath.contains(dirName)){
            this.currentDirectoryPath.remove(dirName);
        }
        this.rawDirectoryPath = this.rawDirectoryPath.replace("/" + dirName, "");

        this.currentDirectory = this.currentDirectory.getParentDirectory();
    }

    public void goToNextDirectory(String directoryName){
        List<Directory> dirCollection = this.currentDirectory.listAllDirectories().stream().filter(t -> t.getName().equals(directoryName)).collect(Collectors.toList());

        if (!dirCollection.isEmpty()){
            this.currentDirectory = dirCollection.get(0);
            this.currentDirectoryPath.add(directoryName);
            this.rawDirectoryPath += ("/" + directoryName);
        }
    }

    public String getRootDirectory() {
        return rootDirectory;
    }

    public String getRawDirectoryPath() {
        return rawDirectoryPath;
    }

    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

    public List<String> getCurrentDirectoryPath() {
        return currentDirectoryPath;
    }
}