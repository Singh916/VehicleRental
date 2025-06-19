package com.example.VehicleRental.service.impl;

import com.example.VehicleRental.entity.User;
import com.example.VehicleRental.repository.UserRepository;
import com.example.VehicleRental.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
         return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: "+id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
          User existingUser = userRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("User not found with id: "+id));
          existingUser.setEmail(user.getEmail());
          existingUser.setName(user.getName());
          existingUser.setPhone(user.getPhone());
          return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
