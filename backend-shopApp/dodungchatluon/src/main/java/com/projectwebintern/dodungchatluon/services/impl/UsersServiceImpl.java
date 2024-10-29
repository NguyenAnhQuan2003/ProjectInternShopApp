package com.projectwebintern.dodungchatluon.services.impl;

import com.projectwebintern.dodungchatluon.dto.UserDTO;
import com.projectwebintern.dodungchatluon.exceptions.DataNotFoundException;
import com.projectwebintern.dodungchatluon.models.RoleEntity;
import com.projectwebintern.dodungchatluon.models.UserEntity;
import com.projectwebintern.dodungchatluon.repositories.RoleRepository;
import com.projectwebintern.dodungchatluon.repositories.UserRepository;
import com.projectwebintern.dodungchatluon.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    @Transactional
    public UserEntity createUser(UserDTO userDTO) throws Exception {
        String phoneNumber = userDTO.getPhoneNumber();
        if(userRepository.existsByPhoneNumber(phoneNumber)){
            throw new DataIntegrityViolationException("Phone number already exists");
        }
        UserEntity newUser = UserEntity.builder()
                .fullName(userDTO.getFullName())
                .phoneNumber(userDTO.getPhoneNumber())
                .address(userDTO.getAddress())
                .password(userDTO.getPassword())
                .dateOfBirth(userDTO.getDateOfBirth())
                .facebookAccountId(userDTO.getFacebookAccountId())
                .googleAccountId(userDTO.getGoogleAccountId())
                .build();
        RoleEntity role = roleRepository.findById(userDTO.getRoleId())
                .orElseThrow(()->new DataNotFoundException("Role not found"));
        newUser.setRole(role);
        if(userDTO.getGoogleAccountId() == 0 && userDTO.getFacebookAccountId() == 0){
            String password = userDTO.getPassword();

        }
        return userRepository.save(newUser);
    }

    @Override
    public String login(String phoneNumber, String password) throws Exception {
        return null;
    }
}
