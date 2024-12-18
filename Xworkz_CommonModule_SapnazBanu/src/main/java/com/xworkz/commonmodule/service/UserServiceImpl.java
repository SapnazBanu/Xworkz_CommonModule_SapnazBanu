package com.xworkz.commonmodule.service;

import com.xworkz.commonmodule.dto.UserDTO;
import com.xworkz.commonmodule.entity.UserEntity;
import com.xworkz.commonmodule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public boolean validateAndSave(UserDTO user) {

        if ( user.getName() == null || user.getPhone() == null || user.getAltPhone() == null|| user.getLocation() == null)
        {
            return false;
        }
        String password = generateRandomPassword();
        UserEntity entity = new UserEntity();
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setAltEmail(user.getAltEmail());
        entity.setPhone(user.getPhone());
        entity.setAltPhone(user.getAltPhone());
        entity.setLocation(user.getLocation());
        entity.setPassword(password);

        try {
            repository.save(entity);
            System.out.println("User details saved successfully: " + user);
            return true;
        } catch (Exception e) {
            System.err.println("Error saving user details: " + e.getMessage());
            return false;
        }
    }
    public static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}
