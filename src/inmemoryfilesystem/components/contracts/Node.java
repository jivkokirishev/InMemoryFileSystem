package inmemoryfilesystem.components.contracts;

import inmemoryfilesystem.common.Validator;
import inmemoryfilesystem.components.Directory;
import inmemoryfilesystem.users.User;

import java.time.ZonedDateTime;

public abstract class Node {

    private Directory parentDirectory;
    private User owner;

    protected String name;
    protected ZonedDateTime createdOn;
    protected ZonedDateTime editedOn;

    public Node(String name, Directory parentDirectory, User owner){
        Validator.checkIfNullOrEmpty(name);
        Validator.checkIfNull(owner, owner.getClass().getName());

        this.name = name;
        this.owner = owner;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
