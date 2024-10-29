package com.projectwebintern.dodungchatluon.repositories;

import com.projectwebintern.dodungchatluon.models.UserEntity;
import com.projectwebintern.dodungchatluon.repositories.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom {
    boolean existsByPhoneNumber(String phoneNumber);
    Optional<UserEntity> findByPhoneNumber(String phoneNumber);
}
