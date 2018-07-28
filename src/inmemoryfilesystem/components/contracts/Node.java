package inmemoryfilesystem.components.contracts;

import inmemoryfilesystem.components.Directory;

import java.time.ZonedDateTime;

public abstract  class Node {
    protected String name;
    private Directory parentDirectory;

    protected ZonedDateTime createdOn;
    protected ZonedDateTime editedOn;

    public Node(String name, Directory parentDirectory){
        this.name = name;
        this.setParentDirectory(parentDirectory);
        this.createdOn = ZonedDateTime.now();
        this.editedOn = ZonedDateTime.now();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCreatedOn(){
        return this.createdOn.toString();
    }

    public String getEditedOn(){
        return this.editedOn.toString();
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(Directory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }
}
