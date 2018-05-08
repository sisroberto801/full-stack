package com.project.diplomaed.web;

import com.project.diplomaed.domain.User;
import com.project.diplomaed.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author rOlguin
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody UserRequestDTO user){
        userService.addUser(user);
        return  new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id){
        return userService.searchByUserId(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity updateUser(@PathVariable Long id,@RequestBody UserRequestDTO userRequestDTO){
        userService.updateByUserIdByUser(id,userRequestDTO);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable Long id){
        userService.deleteByUserId(id);
        return  new ResponseEntity(HttpStatus.OK);
    }




    public static class UserRequestDTO{
        private String firstName;
        private String lastName;
        private String lastName2;
        private Date birthdate;
        private Integer dni;
        private String email;
        private Integer phone;
        private String userName;
        private String password;
        private Boolean status;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getLastName2() {
            return lastName2;
        }

        public void setLastName2(String lastName2) {
            this.lastName2 = lastName2;
        }

        public Date getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(Date birthdate) {
            this.birthdate = birthdate;
        }

        public Integer getDni() {
            return dni;
        }

        public void setDni(Integer dni) {
            this.dni = dni;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Integer getPhone() {
            return phone;
        }

        public void setPhone(Integer phone) {
            this.phone = phone;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Boolean getStatus() {
            return status;
        }

        public void setStatus(Boolean status) {
            this.status = status;
        }
    }

}
