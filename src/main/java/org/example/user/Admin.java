package org.example.user;

public class Admin extends User {
    public Admin(String username, char[] password, String email) {
        super(username, password, email, true);
    }
}
