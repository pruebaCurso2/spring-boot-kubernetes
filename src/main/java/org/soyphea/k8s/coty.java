package org.soyphea.k8s;

import lombok.extern.slf4j.Slf4j;
import org.soyphea.k8s.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class coty  {
    private int n;

    
    public void controller(){
    
    }
    
    public void conection(){
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:derby:memory:myDB;create=true", "login", "");
         }
         catch (SQLException e)
          {
            // do something appropriate with the exception, *at least*:
            e.printStackTrace();
         }
}
