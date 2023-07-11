package org.andrewn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {
    // Dependency Injection
    // Inversion of Control

    private FakeDataSrc connection = null;

    public FakeDataSrc getConnection() {
        if (connection == null) {
            connection = new FakeDataSrc();
            connection.setUser("admin");
            connection.setPass("123123");
            connection.setURL("jdbc:sqlite:test.db");
        }
        return connection;
    }

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        String userName = sc.nextLine();

//        org.andrewn.UserService userService = new org.andrewn.UserService();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
//        UserService userService = ctx.getBean(UserService.class);
//        userService.printUserByName(userName);
//
//        FakeDataSrc fakeDataSrc = ctx.getBean(FakeDataSrc.class);
//
//        userService.printAllUsers();

        Resource resource = ctx.getResource("file://src/main/resources/google_logo.png");
        System.out.println(resource.getFilename());
        resource = ctx.getResource("https://www.google.com");
        System.out.println(resource.getContentAsString(Charset.defaultCharset()));
        System.out.println(resource.getFilename());
    }
}
