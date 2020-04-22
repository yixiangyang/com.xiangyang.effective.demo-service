package com.xiangyang.service;

import com.xiangyang.model.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestUserService extends JpaRepository<TestUser,Long> {
    public Long countByName(String name);

    public List<TestUser> findByName(String name);
}
