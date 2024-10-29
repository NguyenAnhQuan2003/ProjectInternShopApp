package com.projectwebintern.dodungchatluon.services.impl;

import com.projectwebintern.dodungchatluon.dto.CategoryDTO;
import com.projectwebintern.dodungchatluon.models.CategoryEntity;
import com.projectwebintern.dodungchatluon.repositories.CategoriesRepository;
import com.projectwebintern.dodungchatluon.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoriesRepository categoriesRepository;

    @Override
    public CategoryEntity create(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = CategoryEntity
                .builder()
                .name(categoryDTO.getName())
                .build();
        return categoriesRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity getCategoryById(Long id) {
        return categoriesRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Category not found"));
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public CategoryEntity updateCategory(Long id, CategoryDTO categoryDTO) {
        CategoryEntity existingCategory = getCategoryById(id);
        existingCategory.setName(categoryDTO.getName());
        categoriesRepository.save(existingCategory);
        return existingCategory;
    }

    @Override
    public void deleteCategory(Long id) {
        categoriesRepository.deleteById(id);
    }
}
