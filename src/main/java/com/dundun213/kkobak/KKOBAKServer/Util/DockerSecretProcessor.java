package com.dundun213.kkobak.KKOBAKServer.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class DockerSecretProcessor implements EnvironmentPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(DockerSecretProcessor.class);

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String bindPathPpty = environment.getProperty("docker-secret.bind-path");
        logger.info("Docker Secret bind path: {}", bindPathPpty);

        if (bindPathPpty != null) {
            Path bindPath = Paths.get(bindPathPpty);
            if (Files.isDirectory(bindPath)) {
                Map<String, Object> dockerSecrets;
                try {
                    dockerSecrets = Files.list(bindPath)
                            .collect(Collectors.toMap(
                                    path -> {
                                        File secretFile = path.toFile();
                                        String name = secretFile.getName();
                                        logger.info("Found Docker Secret: {}", name);
                                        return name;
                                    },
                                    path -> {
                                        File secretFile = path.toFile();
                                        try {
                                            byte[] content = FileCopyUtils.copyToByteArray(secretFile);
                                            String value = new String(content).trim();
                                            logger.info("Secret value for {}: {}", secretFile.getName(), value);
                                            return value;
                                        } catch (IOException e) {
                                            logger.error("Error reading secret file: {}", secretFile.getName(), e);
                                            throw new RuntimeException(e);
                                        }
                                    }
                            ));
                    logger.info("Loaded Docker Secrets: {}", dockerSecrets.keySet());
                } catch (IOException e) {
                    logger.error("Error listing secret files", e);
                    throw new RuntimeException(e);
                }
                MapPropertySource pptySource = new MapPropertySource("docker-secrets", dockerSecrets);
                environment.getPropertySources().addLast(pptySource);
            } else {
                logger.warn("Docker Secret bind path is not a directory: {}", bindPath);
            }
        } else {
            logger.warn("Docker Secret bind path is not set");
        }
    }
} 