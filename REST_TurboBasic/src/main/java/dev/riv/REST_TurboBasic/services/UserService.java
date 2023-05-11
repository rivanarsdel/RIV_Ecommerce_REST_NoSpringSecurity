package dev.riv.REST_TurboBasic.services;

import dev.riv.REST_TurboBasic.utilities.HashGenerator;
import dev.riv.REST_TurboBasic.modelDTOs.UserDTO;
import dev.riv.REST_TurboBasic.models.User;
import dev.riv.REST_TurboBasic.repositories.UserRepository;
import dev.riv.REST_TurboBasic.repositories.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {
private final UserRepository userRepository;
private final UserAddressRepository userAddressRepository;
private HashGenerator hashGenerator;

@Autowired
    public UserService (UserRepository userRepository, UserAddressRepository userAddressRepository, HashGenerator hashGenerator) {
    this.userRepository = userRepository;
    this.userAddressRepository = userAddressRepository;
    this.hashGenerator = new HashGenerator();
}

public User createUser(UserDTO userDtoObj) throws NoSuchAlgorithmException {

    String localHash = "";
    if(userDtoObj.getUserHash().equals("_")) { localHash = hashGenerator.createMD5Hash(); }
    else localHash = userDtoObj.getUserHash();
    User newUserObj = new User(
            -1,
            localHash,
            userDtoObj.getDisplayName(),
            userDtoObj.getProfilePicture(),
            userDtoObj.getEmail(),
            userDtoObj.getPassword(),
            userDtoObj.getRole(),
            userDtoObj.getDollarBalance()
    );

    return userRepository.save(newUserObj);
}

public List<User> getAllUsers() {
    return userRepository.findAll();
}

public User getUserById(String userHash) {
    return userRepository.findById(userHash).orElse(null);
}

public User updateUser(UserDTO userDtoObj) throws NoSuchAlgorithmException {
    User userObj = userRepository.findById(userDtoObj.getUserHash()).orElse(null);
    userObj.setDisplayName(userDtoObj.getDisplayName());
    userObj.setProfilePicture(userDtoObj.getProfilePicture());
    userObj.setEmail(userDtoObj.getEmail());
    userObj.setPassword(userDtoObj.getPassword());
    userObj.setRole(userDtoObj.getRole());
    userObj.setDollarBalance(userDtoObj.getDollarBalance());
    return userRepository.save(userObj);
}

public void deleteUser(String userHash) {
    userRepository.deleteById(userHash);
}


}
