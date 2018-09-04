package inmemoryfilesystem.components;

import inmemoryfilesystem.components.contracts.Node;
import inmemoryfilesystem.users.User;

public class File extends Node {
    private String content;
    private String extention;
    private boolean isOpened;

    public File(String name, String content, String extention, Directory parentDirectory, User owner){
        super(name, parentDirectory, owner);

        this.content = content;
        this.extention = extention;
        this.isOpened = false;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public void setIsOpened(boolean isOpened){
        this.isOpened = isOpened;
    }

    public boolean getIsOpened(){
        return this.isOpened;
    }
}
