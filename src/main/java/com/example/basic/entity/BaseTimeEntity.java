package com.example.basic.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
public abstract class BaseTimeEntity {
    @CreatedDate
    private Long createDateTime = null;

    @LastModifiedDate
    private Long lastModifiedDate;

    protected BaseTimeEntity () {
        if (createDateTime == null) {
            this.createDateTime = System.currentTimeMillis();
        }
        this.lastModifiedDate = System.currentTimeMillis();
    }

}
