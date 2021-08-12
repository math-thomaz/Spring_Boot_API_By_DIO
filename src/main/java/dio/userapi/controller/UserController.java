package dio.userapi.controller;

import dio.userapi.dto.request.UserDTO;
import dio.userapi.dto.response.MessageResponseDTO;
import dio.userapi.entity.User;
import dio.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/user")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.createUser(userDTO);
    }
}
