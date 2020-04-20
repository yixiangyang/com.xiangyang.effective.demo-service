package com.xiangyang.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@SpringBootTest(classes = Application.class)

@RunWith(SpringRunner.class)
public class ApplicationTests {
	@Resource
	private TestUserService testUserService;

	@Test
	public void contextLoads() {
		TestUser t = new TestUser();
		t.setName("这个是测试1");
		testUserService.save(t);
	}

	@Test
	public void aa(){
		TestUser t = new TestUser();
		t.setName("这个是测试");
		testUserService.save(t);
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
}
