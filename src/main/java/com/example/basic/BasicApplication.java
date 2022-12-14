package com.example.basic;

import com.example.basic.properties.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@EnableMongoAuditing
// 위의 어노테이션은 누가 언제와 같은 생성일 수정일 등의 컬럼을 디비에 자동으로 생성할 수 있도록 해주는 어노테이션이다.
public class BasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

}
