package com.project.diplomaed.web;

import com.project.diplomaed.domain.Person;
import com.project.diplomaed.domain.User;
import com.project.diplomaed.service.PersonService;
import com.project.diplomaed.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 4/30/2018.
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deletePerson(@PathVariable Long id){
        personService.deleteByPersonId(id);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{firstName}",method = RequestMethod.GET)
    public List<Person> getPersonList(@PathVariable String firstName){
        return personService.getPersonListConverter(firstName);
    }
}
