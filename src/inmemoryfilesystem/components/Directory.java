package inmemoryfilesystem.components;

import inmemoryfilesystem.common.Validator;
import inmemoryfilesystem.components.contracts.Node;
import inmemoryfilesystem.users.User;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Directory extends Node {
    private Map<String, Directory> directories;
    private Map<String, File> files;

    public Directory(String name, Directory parentDirectory, User owner){
        super(name, parentDirectory, owner);
        this.directories = new HashMap<>();
        this.files = new HashMap<>();
    }

    public void addDirectory(String name){
        Validator.checkIfNullOrEmpty(name);

        if(this.directories.containsKey(name)){
            System.out.println("This folder already exists. It can NOT be created again.");

            return;
        }

        this.directories.put(name, new Directory(name, this, this.getOwner()));
        this.editedOn = ZonedDateTime.now();
    }

    public boolean deleteDirectory(String name){
        Validator.checkIfNullOrEmpty(name);

        if(!this.directories.containsKey(name)){
            //System.out.println("There is no such folder.");

            return false;
        }

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

        return true;
    }

    public boolean deleteDirectoryRecursively(String name){
        Validator.checkIfNullOrEmpty(name);

        if(!this.directories.containsKey(name)){
            //System.out.println("There is no such folder.");

            return false;
        }

        this.directories.remove(name);
        this.editedOn = ZonedDateTime.now();

        return true;
    }

    public void addFile(String name, String content, String extension){
        Validator.checkIfNullOrEmpty(name);

        String fullName = extension.isEmpty() ? name : String.format("%s.%s", name, extension);
        if(this.directories.containsKey(fullName)){
            System.out.println("This file already exists. It can NOT be created again.");

            return;
        }

        this.files.put(fullName, new File(name, content, extension, this, this.getOwner()));
        this.editedOn = ZonedDateTime.now();
    }

    public boolean deleteFile(String fullName){
        Validator.checkIfNullOrEmpty(fullName);

        if(!this.files.containsKey(fullName)){
            //System.out.println("There is no such file.");

            return false;
        }

        this.files.remove(fullName);
        this.editedOn = ZonedDateTime.now();

        return true;
    }

    public Collection<File> listAllFiles(){
        return this.files.values();
    }

    public Collection<Directory> listAllDirectories(){
        return this.directories.values();
    }
}
