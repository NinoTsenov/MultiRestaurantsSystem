package com.NinoAndCheciRestaurants.restaurantsSystem.controller;

import com.NinoAndCheciRestaurants.restaurantsSystem.dto.CategoryRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.CategoryResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor

public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/createCategory")
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request){
        CategoryResponse createdCategory = categoryService.createCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryResponse> updateCategory
            (@PathVariable Long id, @Valid @RequestBody CategoryRequest request){
        CategoryResponse updatedCategory = categoryService.updateCategory(id, request);
        if(updatedCategory!=null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.GONE).body("Category was successfully deleted");
    }

}
