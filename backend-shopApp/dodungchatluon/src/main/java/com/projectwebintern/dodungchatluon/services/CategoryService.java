package com.projectwebintern.dodungchatluon.services;

import com.projectwebintern.dodungchatluon.dto.CategoryDTO;
import com.projectwebintern.dodungchatluon.models.CategoryEntity;

import java.util.List;

public interface CategoryService {
    CategoryEntity create(CategoryDTO categoryDTO);
    CategoryEntity getCategoryById(Long id);
    List<CategoryEntity> getAllCategories();
    CategoryEntity updateCategory(Long id, CategoryDTO categoryDTO);
    void deleteCategory(Long id);
}
