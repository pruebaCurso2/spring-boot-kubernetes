package org.soyphea.k8s;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.soyphea.k8s.config.UserConfig;
import org.soyphea.k8s.controller.Controller;
import org.soyphea.k8s.srevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.h2.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(Controller.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    static class UserConfigTestConfig {
        @Bean
        UserConfig userConfig() {
            return new UserConfig("dara", "ok");
        }

        @Bean
        UserService userService() {
            return new UserService();
            }
    }

    @Test
    @DisplayName("When calling the correct endpoint should be ok.")
    public void test_ok() throws Exception {
        mockMvc.perform(get("/k8s/Dara")).andExpect(MockMvcResultMatchers.status().isOk());
    try
    {
       Connection conn = DriverManager.getConnection("jdbc:derby:memory:myDB;create=true", "login", "");
    }
    catch (SQLException e)
    {
        // do something appropriate with the exception, *at least*:
        e.printStackTrace();
    }
        
    String inputString = "s3cr37";
    byte[] key         = inputString.getBytes();

    SHA256.getHMAC(key, message);  // Noncompliant
 }
}
