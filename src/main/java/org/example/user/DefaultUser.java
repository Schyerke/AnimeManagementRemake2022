package org.example.user;

public class DefaultUser extends User {
    public DefaultUser(String username, char[] password, String email) {
        super(username, password, email, false);
    }
}
