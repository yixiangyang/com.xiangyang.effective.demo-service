package com.xiangyang.application;

import com.xiangyang.application.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserService extends JpaRepository<TestUser,Long> {
}
