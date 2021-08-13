package dio.userapi.service;

import dio.userapi.dto.request.UserDTO;
import dio.userapi.dto.response.MessageResponseDTO;
import dio.userapi.entity.User;
import dio.userapi.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static dio.userapi.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGivenUserDTOThenReturnSavedMessage() {
        UserDTO userDTO = createFakeDTO();
        User expectedSavedUser = createFakeEntity();

        when(userRepository.save(any(User.class))).thenReturn(expectedSavedUser);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedUser.getId());
        MessageResponseDTO successMessage = userService.createUser(userDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("User created with Id " + id)
                .build();
    }
}
