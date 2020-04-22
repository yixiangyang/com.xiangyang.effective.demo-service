package com.xiangyang.service;

import com.xiangyang.model.TestUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestUserCrudService extends CrudRepository<TestUser,Long> {


    public TestUser findDistinctById(Long id);

    public Long countDistinctByNameEquals(String name);
}
