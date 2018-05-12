package com.project.diplomaed.service;

import com.project.diplomaed.domain.Person;
import com.project.diplomaed.domain.User;
import com.project.diplomaed.dto.UserDTO;
import com.project.diplomaed.repository.PersonRepository;
import com.project.diplomaed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author rOlguin
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public User addUser(UserDTO userDTO){
        Person person = changeDTOToObject(new User(),new Person(), userDTO);
        personRepository.save(person);
        return person.getUser();
    }

    @Transactional
    public void deleteByUserId(Long userId){
        userRepository.delete(userId);
    }

    @Transactional
    public void updateByUserIdByUser(Long userId,UserDTO userDTO){
        User user = userRepository.findOne(userId);
        Person person = personRepository.findOne(user.getPerson().getId());
        personRepository.save(changeDTOToObject(user
                ,person
                , userDTO)
        );
    }

    public User searchByUserId(Long userId){
        return userRepository.findOne(userId);
    }


    private Person changeDTOToObject(User user,Person person,UserDTO userDTO){
        user.setPerson(person);
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setStatus(userDTO.getStatus());
        person.setUser(user);
        return person;
    }


    public User findUserByUserNameByPassword(String userName, String password){
        return userRepository.findUserByUserNameByPassword(userName,password);
    }
}
