package inmemoryfilesystem.users;

import inmemoryfilesystem.common.Validator;

public class User {

    private String name;
    private String password;
    // There can be added other properties in the future.

    public User(String name, String password){
        Validator.checkIfNullOrEmpty(name);
        Validator.checkIfNullOrEmpty(password);

        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
