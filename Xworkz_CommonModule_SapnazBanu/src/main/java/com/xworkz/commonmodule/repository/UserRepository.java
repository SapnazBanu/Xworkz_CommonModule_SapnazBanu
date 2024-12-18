package com.xworkz.commonmodule.repository;

import com.xworkz.commonmodule.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    boolean save(UserEntity entity);
}
