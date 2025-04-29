package com.dundun213.kkobak.KKOBAKServer.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${DB_HOST}")
    private String dbHost;

    @Value("${DB_PORT}")
    private String dbPort;

    @Value("${DB_USERNAME}")
    private String dbUsername;

    @Value("${DB_PASSWORD}")
    private String dbPassword;

//    @Value("${JWT_SECRET}")
//    private String jwtSecret;

    @Value("${GOOGLE_CLIENT_ID}")
    private String googleClientId;

    // Getter and Setter methods
}