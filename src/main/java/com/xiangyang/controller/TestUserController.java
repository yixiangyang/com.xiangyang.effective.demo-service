package com.xiangyang.controller;

import com.xiangyang.model.TestUser;
import com.xiangyang.service.TestUserService;
import com.xiangyang.util.ExcelFormat;
import com.xiangyang.util.ExcelHeaderInfo;
import com.xiangyang.util.ExcelUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/aaa")
    public void getAA(HttpServletResponse response){
        List<TestUser> list = testUserService.findAll();
        ExcelUtils excelUtils = new ExcelUtils(list,getHeaderInfo(),new HashMap<String, ExcelFormat>());
        excelUtils.sendHttpResponse(response,"name",excelUtils.getWorkbook());
    }

    // 获取表头信息
    private List<ExcelHeaderInfo> getHeaderInfo() {
        return Arrays.asList(new ExcelHeaderInfo(0,0,0,0,"id"),new ExcelHeaderInfo(0,0,1,1,"名字"));
    }
}
