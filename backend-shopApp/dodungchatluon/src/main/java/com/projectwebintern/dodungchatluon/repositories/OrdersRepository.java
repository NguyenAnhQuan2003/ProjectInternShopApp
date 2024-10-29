package com.projectwebintern.dodungchatluon.repositories;

import com.projectwebintern.dodungchatluon.models.OrderEntity;
import com.projectwebintern.dodungchatluon.repositories.custom.OrdersRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrderEntity, Long>, OrdersRepositoryCustom {
}
