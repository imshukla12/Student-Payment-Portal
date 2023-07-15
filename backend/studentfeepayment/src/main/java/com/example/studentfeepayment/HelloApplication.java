package com.example.studentfeepayment;

import com.example.studentfeepayment.Util.CORSFilter;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
//public class HelloApplication extends Application {
//
//}

public class HelloApplication extends ResourceConfig {
    public HelloApplication() {
        // Registering the CORSFilter class with the Jersey ResourceConfig
        register(CORSFilter.class);

        // Telling Jersey the CLASSPATH where the specified classes (in our case, CORSFilter) can be found
        packages("com.example.studentfeepayment");
    }
}