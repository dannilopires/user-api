package one.digitalinnovation.UserAPI.service;

import one.digitalinnovation.UserAPI.dto.MessageResponseDTO;
import one.digitalinnovation.UserAPI.dto.request.UserDTO;
import one.digitalinnovation.UserAPI.entity.User;
import one.digitalinnovation.UserAPI.exception.UserNotFoundException;
import one.digitalinnovation.UserAPI.mapper.UserMapper;
import one.digitalinnovation.UserAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service //Indica que a classe será responsável por todas as regras de negócio da app
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MessageResponseDTO createUser(UserDTO userDTO) {
        User userToSave = userMapper.toModel(userDTO);

        User savedUser = userRepository.save(userToSave);
        return createMessageResponse(savedUser.getId(), "Created user with ID ");
    }

    public List<UserDTO> listAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) throws UserNotFoundException {
        User user = verifyIfExists(id);

        return userMapper.toDTO(user);

        /*Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(id);
        }
        return userMapper.toDTO(optionalUser.get());
        */
    }

    public void delete(Long id) throws UserNotFoundException {
        User user = verifyIfExists(id);

        userRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, UserDTO userDTO) throws UserNotFoundException {
        verifyIfExists(id);

        User userToUpdate = userMapper.toModel(userDTO);

        User updateUser = userRepository.save(userToUpdate);
        return createMessageResponse(updateUser.getId(), "Updated user with ID ");
    }

    private User verifyIfExists(Long id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
