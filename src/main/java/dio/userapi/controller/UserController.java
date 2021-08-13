package dio.userapi.controller;

import dio.userapi.dto.request.UserDTO;
import dio.userapi.dto.response.MessageResponseDTO;
import dio.userapi.entity.User;
import dio.userapi.exception.UserNotFoundException;
import dio.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    
    @GetMapping("/api/v1/user")
    public List<UserDTO> listAll() {
        return userService.listAll();
    }

    @GetMapping("/api/v1/user/{id}")
    public UserDTO findById(@PathVariable Long id) throws UserNotFoundException {
        return userService.findById(id);
    }

    @PutMapping("/api/v1/user/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO) throws UserNotFoundException {
        return userService.updateById(id, userDTO);
    }

    @DeleteMapping("/api/v1/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws UserNotFoundException {
        userService.delete(id);
    }
}
