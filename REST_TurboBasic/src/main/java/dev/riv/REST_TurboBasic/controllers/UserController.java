package dev.riv.REST_TurboBasic.controllers;

import dev.riv.REST_TurboBasic.modelDTOs.UserDTO;
import dev.riv.REST_TurboBasic.modelHelpers.UserAddress;
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
        User userObj = userService.createUser(userDTO);
        return Optional.of(userObj);
    }
    @PostMapping("/register/address")
    public Optional<UserAddress> registerAddress(@RequestBody UserDTO userDTO) throws NoSuchAlgorithmException {
        if(userDTO.getUserHash().equals("")) { return Optional.empty(); } else {
            UserAddress userAddressObj = userService.createUserAddress(userDTO);
            return Optional.of(userAddressObj);
        }
    }

    @GetMapping("/get")
    public Optional<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return Optional.of(userList);
    }

    @GetMapping("/get/address")
    public Optional<List<UserAddress>> getAllUserAddresses() {
        List<UserAddress> userAddressList = userService.getAllUserAddresses();
        return Optional.of(userAddressList);
    }

    @GetMapping("/get/address/{userHash}")
    public Optional<List<UserAddress>> getAllLinkedAddresses (@PathVariable String userHash) {
        List<UserAddress> userAddressList = userService.getAllLinkedAddresses(userHash);
        return Optional.of(userAddressList);
    }

    @GetMapping("/get/{userHash}")
    public Optional<User> getUserByHash(@PathVariable String userHash) {
        User userObj = userService.findByUserHash(userHash);
        return Optional.of(userObj);
    }

    @PutMapping("/user/update")
    public Optional<User> updateUser(UserDTO userDTO) throws NoSuchAlgorithmException {
        User userObj = userService.updateUser(userDTO);
        return Optional.of(userObj);
    }

    @PutMapping("/user/update/address")
    public Optional<UserAddress> updateUserAddress(UserDTO userDTO) throws NoSuchAlgorithmException {
        UserAddress userAddressObj = userService.updateUserAddress(userDTO);
        return Optional.of(userAddressObj);
    }

    @DeleteMapping("/user/delete/{userHash}")
    public Optional<User> deleteUser(@PathVariable String userHash) {
        User userObj = userService.findByUserHash(userHash);
        userService.deleteUserByHash(userObj.getUserHash());
        return Optional.of(userObj);
    }


}