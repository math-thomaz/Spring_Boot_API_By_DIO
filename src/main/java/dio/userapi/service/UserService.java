package dio.userapi.service;

import dio.userapi.dto.request.UserDTO;
import dio.userapi.dto.response.MessageResponseDTO;
import dio.userapi.entity.User;
import dio.userapi.mapper.UserMapper;
import dio.userapi.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private IUserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MessageResponseDTO createUser(UserDTO userDTO) {
        User userToSave = userMapper.toModel(userDTO);

        User registeredUser = userRepository.save(userToSave);
        return MessageResponseDTO
                .builder()
                .message("User created with Id " + registeredUser.getId())
                .build();
    }
}
