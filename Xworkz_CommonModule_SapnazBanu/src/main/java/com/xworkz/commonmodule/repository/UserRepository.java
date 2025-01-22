package com.xworkz.commonmodule.repository;


import com.xworkz.commonmodule.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    boolean save(UserEntity userEntity);
    Long countByLocation(String location);
    Long countByAltPhone(long altPhone);
    Long countByPhone(long phone);
    Long countAltEmail(String altEmail);
    String getNameByEmailAndPassword(String email, String password);
    Long countName(String name);
    Long countByEmail(String email);
    UserEntity getUserByEmail(String email);
    public boolean saveEmail(String email, String password);
    public UserEntity updateUserEntity(String email,String name, String location, Long altPhone, Long phone, String altEmail);
    public String forgotPassword(String email,String password);
}
