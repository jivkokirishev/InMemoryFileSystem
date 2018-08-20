package inmemoryfilesystem.users;

import java.util.LinkedList;
import java.util.List;

public class UserState {
    private List<User> users;
    private boolean isLoggedIn;

    private User currentUser;

    public UserState () {
        this.users = new LinkedList<>();

        User rootUsr = new User("root", "root");
        this.users.add(rootUsr);
        this.currentUser = rootUsr;
        this.isLoggedIn = true;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
