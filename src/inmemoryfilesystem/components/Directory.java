package inmemoryfilesystem.components;

import inmemoryfilesystem.components.contracts.Node;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Directory extends Node {
    private Map<String, Directory> directories;
    private Map<String, File> files;

    public Directory(String name, Directory parentDirectory){
        super(name, parentDirectory);
        this.directories = new HashMap<>();
        this.files = new HashMap<>();
    }

    public void addDirectory(String name, Directory directory){
        this.directories.put(name, directory);
        this.editedOn = ZonedDateTime.now();
    }

    public void deleteDirectory(String name){
        Directory dirForDel = this.directories.get(name);

        dirForDel.directories.forEach((k,v)->{
            v.setParentDirectory(this);
            this.directories.put(k,v);
        });
        dirForDel.files.forEach((k,v) ->{
            v.setParentDirectory(this);
            this.files.put(k,v);
        });

        this.directories.remove(name);
        this.editedOn = ZonedDateTime.now();
    }

    public void deleteDirectoryRecursively(String name){
        this.directories.remove(name);
        this.editedOn = ZonedDateTime.now();
    }

    public void addFile(String name, File file){
        this.files.put(name, file);
        this.editedOn = ZonedDateTime.now();
    }

    public void deleteFile(String name){
        this.files.remove(name);
        this.editedOn = ZonedDateTime.now();
    }

    public Collection<File> listAllFiles(){
        return this.files.values();
    }

    public Collection<Directory> listAllDirectories(){
        return this.directories.values();
    }
}
