package com.example.basic.controller;

import com.example.basic.entity.User;
import com.example.basic.service.FilesService;
import com.example.basic.service.UserService;
import lombok.AllArgsConstructor;
import org.bson.types.Binary;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

// TODO: swagger 추가 하기


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    //https://goddaehee.tistory.com/203

    private final UserService userService;
    private final FilesService filesService;
// https://jaimemin.tistory.com/2072
    @PostMapping(value="/register", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity addUser(HttpServletRequest request, @RequestPart(value="user") User user, @RequestPart(value="file", required=false) MultipartFile file) throws IOException {
        this.userService.register(user, file);
        return ResponseEntity.ok().header("result","success").body(null);
    }

    @PostMapping(value="/register/profile-image")
    public void addUserProfileImage() {

    }


    @GetMapping("/user/profile/{id}")
    public void findUserImage(@PathVariable String id) throws IOException {
        this.userService.findUserImage(id);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable String id) {
        return this.userService.findById(id);
    }

    @GetMapping()
    public List<User> findAll() {
        return this.userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable String id) {
        this.userService.removeById(id);
    }

    @GetMapping("/nick/{nickName}")
    public User findUserByNickName(@PathVariable String nickName) {
        return this.userService.findUserByNickName(nickName);
    }

    @GetMapping("/name/{userName}")
    public User findUserByUserName(@PathVariable String userName) {
        return this.userService.findUserByUserName(userName);
    }
}
//mongodb://admin:admin@localhost:27017/?authMechanism=DEFAULT