package inmemoryfilesystem.components;

import inmemoryfilesystem.components.contracts.Node;
import inmemoryfilesystem.users.User;

public class File extends Node {
    private String content;
    private String extention;

    public File(String name, String content, String extention, Directory parentDirectory, User owner){
        super(name, parentDirectory, owner);

        this.content = content;
        this.extention = extention;
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
}
