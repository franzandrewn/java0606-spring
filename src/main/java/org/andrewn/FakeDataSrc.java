package org.andrewn;

public class FakeDataSrc {
    public static int count = 0;
    private String user;
    private String pass;
    private String URL;

    public FakeDataSrc() {
        count++;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public User findUser(String name) throws Exception {
        // transaction start
        if (name.matches("[a-z].*")) {
            return null;
        } else if (name.matches("[A-Z].*")) {
            return new User(name, name.length());
        }
        throw new Exception("No user exception");
        // transaction end
    }
}
