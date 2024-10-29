package com.projectwebintern.dodungchatluon.repositories;

import com.projectwebintern.dodungchatluon.models.ProductEntity;
import com.projectwebintern.dodungchatluon.repositories.custom.ProductsRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductEntity, Long>, ProductsRepositoryCustom {
}
