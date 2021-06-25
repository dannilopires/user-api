package one.digitalinnovation.UserAPI.service;

import one.digitalinnovation.UserAPI.dto.MessageResponseDTO;
import one.digitalinnovation.UserAPI.dto.request.UserDTO;
import one.digitalinnovation.UserAPI.entity.User;
import one.digitalinnovation.UserAPI.mapper.UserMapper;
import one.digitalinnovation.UserAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Indica que a classe será responsável por todas as regras de negócio da app
public class UserService {
    private UserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MessageResponseDTO createUser(UserDTO userDTO) {
        User userToSave = userMapper.toModel(userDTO);

        User savedUser = userRepository.save(userToSave);
        return MessageResponseDTO
                .builder()
                .message("Created user with ID " + savedUser.getId())
                .build();
    }
}
