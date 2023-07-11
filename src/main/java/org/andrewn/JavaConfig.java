package org.andrewn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySources(
        {@PropertySource("application.properties"),
        @PropertySource("database.properties")}
)
public class JavaConfig {

    @Value("${database.username}")
    private String username;

    @Value("${database.pass}")
    private String pass;

    @Value("${database.url}")
    private String URL;

    @Bean
    public FakeDataSrc fakeDataSrc() {
        FakeDataSrc connection = new FakeDataSrc();
        connection.setUser(username);
        connection.setPass(pass);
        connection.setURL(URL);
        return connection;
    }

//    @Bean
//    public org.andrewn.UserService userService() {
//        return new org.andrewn.UserService(fakeDataSrc());
//    }
}
