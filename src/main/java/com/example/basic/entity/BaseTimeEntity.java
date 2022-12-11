package com.example.basic.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("User")
public abstract class BaseTimeEntity {
    @CreatedDate
    private Long createDateTime;

    @LastModifiedDate
    private Long lastModifiedDate;

//    protected BaseTimeEntity () {
//        this.createDateTime = System.currentTimeMillis();
//        this.lastModifiedDate = System.currentTimeMillis();
//    }
}
