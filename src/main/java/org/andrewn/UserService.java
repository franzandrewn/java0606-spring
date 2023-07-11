package org.andrewn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final FakeDataSrc connection;

    public UserService() {
        connection = new Main().getConnection();
    }

    public UserService(FakeDataSrc connection) {
        this.connection = connection;
    }

    private FakeDataSrc createConnection() {
        FakeDataSrc fakeDataSrc = new FakeDataSrc();
        fakeDataSrc.setUser("admin");
        fakeDataSrc.setPass("123123");
        fakeDataSrc.setURL("jdbc:sqlite:test.db");
        return fakeDataSrc;
    }

    public void printUserByName(String name) {
        try {
            User user = connection.findUser(name);
            System.out.println(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void printAllUsers() {
        try {
            User user = connection.findUser("Phil");
            System.out.println(user);
            user = connection.findUser("Andrew");
            System.out.println(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
