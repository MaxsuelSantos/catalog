package com.max.catalog.repositories;

import com.max.catalog.entities.Category;
import com.max.catalog.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categories cats WHERE " +
            "( :category IS NULL OR :category IN cats ) AND " +
            "( LOWER(obj.name) LIKE LOWER(CONCAT('%', :name, '%')) )")
    Page<Product> find(Category category, String name, Pageable pageable);
}
