package com.project.diplomaed.service;

import com.project.diplomaed.domain.User;
import com.project.diplomaed.repository.UserRepository;
import com.project.diplomaed.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rOlguin
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(UserController.UserRequestDTO user){
        userRepository.save(changeDTOToObject(new User(),user));
    }

    public void deleteByUserId(Long userId){
        userRepository.delete(userId);
    }

    public void updateByUserIdByUser(Long userId,UserController.UserRequestDTO user){
        userRepository.save(changeDTOToObject(userRepository.findOne(userId),user));
    }

    public User searchByUserId(Long userId){
        return userRepository.findOne(userId);
    }


    private User changeDTOToObject(User temp,UserController.UserRequestDTO user){
//        temp.setFirstName(user.getFirstName());
//        temp.setLastName(user.getLastName());
//        temp.setEmail(user.getEmail());
        temp.setUserName(user.getUserName());
        temp.setPassword(user.getPassword());
        //temp.setStatus(user.getStatus());
        return temp;
    }
}
