package com.ecommerce.repositories;

import com.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    // jpa implemented it automatically
    Category findByCategoryName(String categoryName);
}