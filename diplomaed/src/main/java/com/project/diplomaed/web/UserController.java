package com.project.diplomaed.web;

import com.project.diplomaed.common.BuildResponse;
import com.project.diplomaed.domain.User;
import com.project.diplomaed.dto.UserDTO;
import com.project.diplomaed.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rOlguin
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BuildResponse buildResponse;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public BuildResponse getUsers(){
        List<User> list = userService.getAllUsers();
        try {
            buildResponse.clean();
            buildResponse.setResult(userService.getAllUsers());
            buildResponse.setStatus("ok");
            buildResponse.setTotal(list.size());
            buildResponse.setSuccess("true");
        } catch (Exception e) {
            buildResponse.clean();
            buildResponse.setStatus("Error getting Advanced Search lookup data.");
            buildResponse.setSuccess("false");
            logger.error("Error while executing getLKAccInternalUseDataCode", e);
        }
        return buildResponse;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public User addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id){
        return userService.searchByUserId(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity updateUser(@PathVariable Long id,@RequestBody UserDTO userDTO){
        userService.updateByUserIdByUser(id, userDTO);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable Long id){
        userService.deleteByUserId(id);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BuildResponse getUserByUserNameByPassword(@RequestBody UserDTO userDTO){
        try {
            buildResponse.clean();
            buildResponse.setResult(userService.findUserByUserNameByPassword(userDTO.getUserName(),userDTO.getPassword()));
            buildResponse.setStatus("ok");
            buildResponse.setSuccess("true");
        } catch (Exception e) {
            buildResponse.clean();
            buildResponse.setStatus("Error getting Advanced Search lookup data.");
            buildResponse.setSuccess("false");
            logger.error("Error while executing getLKAccInternalUseDataCode", e);
        }
        return buildResponse;
    }
}
