package com.xworkz.commonmodule.service;

import com.xworkz.commonmodule.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean validateAndSave(UserDTO user);
}
