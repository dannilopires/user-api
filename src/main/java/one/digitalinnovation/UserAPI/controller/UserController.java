package one.digitalinnovation.UserAPI.controller;

import one.digitalinnovation.UserAPI.dto.MessageResponseDTO;
import one.digitalinnovation.UserAPI.dto.request.UserDTO;
import one.digitalinnovation.UserAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(("/api/v1/users"))
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> listAll() {
        return userService.listAll();
    }
}
