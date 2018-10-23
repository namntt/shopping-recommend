package com.nam.core.service.impl;

import com.nam.core.dto.UserDTO;
import com.nam.core.entity.User;
import com.nam.core.repository.UserRepository;
import com.nam.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUser() {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = (List<User>) userRepository.findAll();
        users.forEach(user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setFullName(user.getFullName());
            userDTO.setEmail(user.getEmail());
            userDTO.setCreatedDate(user.getCreatedDate());
            userDTO.setUpdatedDate(user.getUpdatedDate());
            userDTOS.add(userDTO);
        });
        return userDTOS;
    }
}
