package one.digitalinnovation.UserAPI.service;

import one.digitalinnovation.UserAPI.dto.MessageResponseDTO;
import one.digitalinnovation.UserAPI.entity.User;
import one.digitalinnovation.UserAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service //Indica que a classe será responsável por todas as regras de negócio da app
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MessageResponseDTO createUser(User user) {
        User userSaved = userRepository.save(user);
        return MessageResponseDTO
                .builder()
                .message("Created user with ID " + userSaved.getId())
                .build();
    }
}
