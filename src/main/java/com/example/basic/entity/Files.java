package com.example.basic.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.websocket.Decoder;

@Getter
@Setter
@Data
@Document("Files")
public class Files {

    @Id
    private String id;
    private String filesId;
    private Binary files;


}
