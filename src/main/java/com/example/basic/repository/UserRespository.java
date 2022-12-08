package com.example.basic.repository;

import com.example.basic.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends MongoRepository<User, String> {
    User findByUserNameRegex(String userName);
    User findByNickNameRegex(String nickName);
}
