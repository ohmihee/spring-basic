package com.example.basic.service;

import com.example.basic.entity.Files;
import com.example.basic.repository.FilesRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FilesService {

    @Autowired
    private FilesRepository filesRepository;

    public void readFiles(Binary binary, String userNick) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("/Users/mihee/Downloads/"+userNick+".jpg")) {
            fos.write(binary.getData());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    };

}
