package com.project.diplomaed.service;

import com.project.diplomaed.domain.Person;
import com.project.diplomaed.repository.PersonRepository;
import com.project.diplomaed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 4/30/2018.
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public void deleteByPersonId(Long personId){
        personRepository.delete(personId);
    }

    public List<Person> getPersonListConverter(String firstName){
        return personRepository.findConverter(firstName);
    }
}
