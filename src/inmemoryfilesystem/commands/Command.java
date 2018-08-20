package inmemoryfilesystem.commands;

import inmemoryfilesystem.common.Validator;

import java.util.List;

public class Command {

    private String name;
    private List<String> parameters;
    private List<String> flags;

    public Command(String name, List<String> parameters, List<String> flags){
        Validator.checkIfNullOrEmpty(name);
        Validator.checkIfNull(parameters, parameters.getClass().getName());
        Validator.checkIfNull(flags, flags.getClass().getName());

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
