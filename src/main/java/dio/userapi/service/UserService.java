package dio.userapi.service;

import dio.userapi.dto.request.UserDTO;
import dio.userapi.dto.response.MessageResponseDTO;
import dio.userapi.entity.User;
import dio.userapi.exception.UserNotFoundException;
import dio.userapi.mapper.UserMapper;
import dio.userapi.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<UserDTO> listAll() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    private User verifyIsExists(Long id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public UserDTO findById(Long id) throws UserNotFoundException {
        User user = verifyIsExists(id);

        return userMapper.toDTO(user);
    }

    public void delete(Long id) throws UserNotFoundException {
        verifyIsExists(id);

        userRepository.deleteById(id);
    }
}
