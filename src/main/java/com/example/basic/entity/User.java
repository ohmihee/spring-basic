package com.example.basic.entity;

import com.example.basic.entity.vo.UserRole;
import lombok.*;
import org.bson.types.Binary;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("User")
@Builder
public class User extends BaseTimeEntity{

    @Id
    private String id;
    private String nickName;
    private String password;
    private String userName;
    private Binary image;
    private String fileId;
    private UserRole role;
}
