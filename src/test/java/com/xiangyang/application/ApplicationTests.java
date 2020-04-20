package com.xiangyang.application;

import com.xiangyang.model.TestUser;
import com.xiangyang.service.TestUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		t.setName("这个是测试3");
		testUserService.save(t);
		Pageable pageable = PageRequest.of(0, 5);
		Page<TestUser> testUsers = testUserService.findAll(pageable);
		
		testUsers.getContent().forEach(System.out::println);
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
