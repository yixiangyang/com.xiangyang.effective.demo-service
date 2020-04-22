package com.xiangyang.controller;

import com.xiangyang.model.TestUser;
import com.xiangyang.service.TestUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestUserController {
    @Resource
    private TestUserService testUserService;

    @PostMapping("/test")
    public void getUser(@RequestParam("name") String  name){
        TestUser testUser = new TestUser();
        testUser.setName(name);
        testUserService.save(testUser);
    }
}
