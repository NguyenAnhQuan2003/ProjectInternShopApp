package com.projectwebintern.dodungchatluon.repositories;

import com.projectwebintern.dodungchatluon.models.CategoryEntity;
import com.projectwebintern.dodungchatluon.repositories.custom.CategoryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<CategoryEntity, Long>, CategoryRepositoryCustom {
}
