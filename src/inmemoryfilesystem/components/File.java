package inmemoryfilesystem.components;

import inmemoryfilesystem.components.contracts.Node;

public class File extends Node {
    private String content;
    private String extention;

    public File(String name, String content, String extention, Directory parentDirectory){
        super(name, parentDirectory);
        this.content = content;
        this.extention = extention;
    }
}
