package com.xworkz.commonmodule.service;


import com.xworkz.commonmodule.dto.UserDTO;
import com.xworkz.commonmodule.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
        boolean validAndSave(UserDTO userDto);
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