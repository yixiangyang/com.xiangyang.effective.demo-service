package com.xiangyang.service;

import com.xiangyang.model.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserService extends JpaRepository<TestUser,Long> {
}
