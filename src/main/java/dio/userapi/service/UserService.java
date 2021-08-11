package dio.userapi.service;

import dio.userapi.dto.MessageResponseDTO;
import dio.userapi.entity.User;
import dio.userapi.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MessageResponseDTO createUser(User user) {
        User registeredUser = userRepository.save(user);
        return MessageResponseDTO
                .builder()
                .message("User created with Id " + registeredUser.getId())
                .build();
    }
}
