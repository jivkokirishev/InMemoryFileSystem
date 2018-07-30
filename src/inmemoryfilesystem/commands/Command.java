package inmemoryfilesystem.commands;

import java.util.List;

public class Command {

    private String name;
    private List<String> parameters;
    private List<String> flags;

    public Command(String name, List<String> parameters, List<String> flags){
        this.name = name;
        this.parameters = parameters;
        this.flags = flags;
    }

    public String getName() {
        return name;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public List<String> getFlags() {
        return flags;
    }
}
