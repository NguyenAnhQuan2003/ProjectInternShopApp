package com.projectwebintern.dodungchatluon.controllers;

import com.projectwebintern.dodungchatluon.dto.CategoryDTO;
import com.projectwebintern.dodungchatluon.models.CategoryEntity;
import com.projectwebintern.dodungchatluon.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/categories")
@RequiredArgsConstructor
public class CategorieController {
    private final CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<?> create
            (@RequestBody @Valid CategoryDTO categoriesDTO,
             BindingResult result){
        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errors);
        }
        categoryService.create(categoriesDTO);
        return ResponseEntity.ok("Create category success!");
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryEntity>> getAllCategories
            (@RequestParam("page") int page,
             @RequestParam("limit") int limit){
        List<CategoryEntity> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id,
                                                 @RequestBody @Valid CategoryDTO categoryDTO){
        categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok("Update category success!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Delete category success!");
    }

}
