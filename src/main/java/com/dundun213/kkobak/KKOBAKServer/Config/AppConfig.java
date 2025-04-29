package com.dundun213.kkobak.KKOBAKServer.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${KKOBAK_DB_HOST}")
    private String dbHost;

    @Value("${KKOBAK_DB_PORT}")
    private String dbPort;

    @Value("${KKOBAK_DB_USERNAME}")
    private String dbUsername;

    @Value("${KKOBAK_DB_PASSWORD}")
    private String dbPassword;

    @Value("${KKOBAK_JWT_SECRET_KEY}")
    private String jwtSecret;

    @Value("${KKOBAK_GOOGLE_CLIENT_ID}")
    private String googleClientId;

    // Getter and Setter methods
}