package dev.riv.REST_TurboBasic.controllers;

import dev.riv.REST_TurboBasic.modelDTOs.UserDTO;
import dev.riv.REST_TurboBasic.models.User;
import dev.riv.REST_TurboBasic.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin (origins = { "http://localhost:4200", "http://localhost:5000", "http://localhost:8080" } )
public class UserController {

    private UserService userService;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/register")
    public Optional<User> register(@RequestBody UserDTO userDTO) throws NoSuchAlgorithmException {
        System.out.println("UserDTO: " + userDTO);
        User userObj = userService.createUser(userDTO);
//        System.out.println("userDTO :" + userDTO.getEmail());
        return Optional.of(userObj);
    }
    @GetMapping("/get")
    public Optional<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return Optional.of(userList);
    }

    @GetMapping("/get/{userHash}")
    public Optional<User> getUserById(@PathVariable String userHash) {
        User userObj = userService.getUserById(userHash);
        return Optional.of(userObj);
    }

    @PutMapping("/user/update")
    public Optional<User> updateUser(UserDTO userDTO) throws NoSuchAlgorithmException {
        User userObj = userService.updateUser(userDTO);
        return Optional.of(userObj);
    }

    @DeleteMapping("/user/delete/{userHash}")
    public void deleteUser(@PathVariable String userHash) {
    }


}