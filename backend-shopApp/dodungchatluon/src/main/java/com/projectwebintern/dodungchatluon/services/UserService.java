package com.projectwebintern.dodungchatluon.services;

import com.projectwebintern.dodungchatluon.dto.UserDTO;
import com.projectwebintern.dodungchatluon.models.UserEntity;

public interface UserService {
    UserEntity createUser(UserDTO userDTO) throws Exception;
    String login(String phoneNumber, String password) throws Exception;
}
