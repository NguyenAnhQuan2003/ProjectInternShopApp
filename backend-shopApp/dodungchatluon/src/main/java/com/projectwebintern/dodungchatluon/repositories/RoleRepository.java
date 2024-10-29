package com.projectwebintern.dodungchatluon.repositories;

import com.projectwebintern.dodungchatluon.models.RoleEntity;
import com.projectwebintern.dodungchatluon.repositories.custom.RoleRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>, RoleRepositoryCustom {
}
