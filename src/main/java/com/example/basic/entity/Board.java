package com.example.basic.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Board")
public class Board {
    @Id
    private String id;
    private String titile;
    private String contents;
    private String author;
}
