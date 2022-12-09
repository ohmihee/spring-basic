package com.example.basic.service;

import com.example.basic.entity.User;
import com.example.basic.repository.UserRespository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private  FilesService filesService;
    @Autowired
    private UserRespository userRespository;

    public void register(User user, MultipartFile image) throws IOException {
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        newUser.setNickName(user.getNickName());
        newUser.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
        this.userRespository.save(newUser);
    }

    public void findUserImage(String id) throws IOException {
        User user = this.findById(id);
        this.filesService.readFiles(user.getImage(), user.getNickName());
    }

    public User findById(String id) {
        return this.userRespository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return this.userRespository.findAll();
    }

    public void removeById(String id) {
        this.userRespository.deleteById(id);
    }

    public User findUserByNickName(String nickName) {
        return this.userRespository.findByNickNameRegex(nickName);
    }

    public User findUserByUserName(String UserName) {
        return this.userRespository.findByUserNameRegex(UserName);
    }

    public User modifyUserNick(User user) {
        return this.userRespository.save(user);
    }
}
