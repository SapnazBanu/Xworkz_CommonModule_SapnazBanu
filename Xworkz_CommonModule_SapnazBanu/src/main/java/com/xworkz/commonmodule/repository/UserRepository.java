package com.xworkz.commonmodule.repository;

import com.xworkz.commonmodule.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    boolean save(UserEntity entity);
    String getNameByEmailAndPassword(String email,String password);
    Long countName(String name);
    Long countByEmail(String email);
    Long countByAltEmail(String altEmail);
    Long countByPhone(String phone);
    Long countByAltPhone(String altPhone);
    Long countByLocation(String location);
}
