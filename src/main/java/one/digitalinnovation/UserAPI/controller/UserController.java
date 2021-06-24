package one.digitalinnovation.UserAPI.controller;

import one.digitalinnovation.UserAPI.dto.MessageResponseDTO;
import one.digitalinnovation.UserAPI.entity.User;
import one.digitalinnovation.UserAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api/v1/users"))
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public MessageResponseDTO createUser(@RequestBody User user) {
        User userSaved = userRepository.save(user);
        return MessageResponseDTO
                .builder()
                .message("Created user with ID " + userSaved.getId())
                .build();
    }
}
