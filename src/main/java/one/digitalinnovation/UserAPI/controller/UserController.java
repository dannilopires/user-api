package one.digitalinnovation.UserAPI.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.UserAPI.dto.MessageResponseDTO;
import one.digitalinnovation.UserAPI.dto.request.UserDTO;
import one.digitalinnovation.UserAPI.exception.UserNotFoundException;
import one.digitalinnovation.UserAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(("/api/v1/users"))
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> listAll() {
        return userService.listAll();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) throws UserNotFoundException{
        return userService.findById(id);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws UserNotFoundException {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid UserDTO  userDTO) throws UserNotFoundException {
        return userService.updateById(id, userDTO);

    }
}
