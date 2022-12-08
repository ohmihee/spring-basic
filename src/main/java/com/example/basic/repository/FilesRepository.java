package com.example.basic.repository;

import com.example.basic.entity.Files;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends MongoRepository<Files, String> {
    //
}
