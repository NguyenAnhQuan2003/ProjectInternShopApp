package com.projectwebintern.dodungchatluon.controllers;

import com.projectwebintern.dodungchatluon.dto.UserLoginDTO;
import com.projectwebintern.dodungchatluon.dto.UserDTO;
import com.projectwebintern.dodungchatluon.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody @Valid UserDTO userDTO,
            BindingResult result
            ){
        try {
            if(result.hasErrors()){
                List<String> errors = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errors);
            }
            if(!userDTO.getPassword().equals(userDTO.getRetypePassword())){
                return ResponseEntity.badRequest().body("Passwords don't match");
            }
            userService.createUser(userDTO);
            return ResponseEntity.ok("Register successful");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public  ResponseEntity<String> login
            (@RequestBody @Valid UserLoginDTO userLoginDTO) throws Exception {
        String token = userService.login(userLoginDTO.getPhoneNumber(), userLoginDTO.getPassword());
        return ResponseEntity.ok("some token");
    }
}
