package com.project.diplomaed.service;

import com.project.diplomaed.domain.Person;
import com.project.diplomaed.domain.User;
import com.project.diplomaed.repository.PersonRepository;
import com.project.diplomaed.repository.UserRepository;
import com.project.diplomaed.web.UserController;
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
    public void addUser(UserController.UserRequestDTO user){
        personRepository.save(changeDTOToObject(new User(),new Person(),user));
    }

    @Transactional
    public void deleteByUserId(Long userId){
        userRepository.delete(userId);
    }

    @Transactional
    public void updateByUserIdByUser(Long userId,UserController.UserRequestDTO userRequestDTO){
        User user = userRepository.findOne(userId);
        Person person = personRepository.findOne(user.getPerson().getId());
        personRepository.save(changeDTOToObject(user
                ,person
                ,userRequestDTO)
        );
    }

    public User searchByUserId(Long userId){
        return userRepository.findOne(userId);
    }


    private Person changeDTOToObject(User user,Person person,UserController.UserRequestDTO userRequestDTO){
        person.setFirstName(userRequestDTO.getFirstName());
        person.setLastName(userRequestDTO.getLastName());
        person.setLastName2(userRequestDTO.getLastName2());
        person.setBirthdate(userRequestDTO.getBirthdate());
        person.setDni(userRequestDTO.getDni());
        person.setEmail(userRequestDTO.getEmail());
        person.setPhone(userRequestDTO.getPhone());

        user.setPerson(person);
        user.setUserName(userRequestDTO.getUserName());
        user.setPassword(userRequestDTO.getPassword());
        user.setStatus(userRequestDTO.getStatus());
        person.setUser(user);

        return person;
    }
}
