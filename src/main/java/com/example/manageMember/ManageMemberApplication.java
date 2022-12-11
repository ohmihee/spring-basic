package com.example.manageMember;

import com.example.basic.properties.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@EnableMongoAuditing
public class ManageMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageMemberApplication.class, args);
    }
}