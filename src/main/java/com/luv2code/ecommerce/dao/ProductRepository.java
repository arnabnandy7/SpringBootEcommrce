package com.luv2code.ecommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.ecommerce.entity.Product;

// If we're not mentioning any resource url then it'll consider the key 
// as url resource and make it's first letter lower caps and add a 's' to end
// For this case the url resource will be accessible by "products" which
// derived from Product in JpaRepository

@CrossOrigin
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Page<Product> findByCategoryId(@RequestParam("id") Integer id, Pageable pageable);

	Page<Product> findByNameContainingIgnoreCase(@RequestParam("name") String name, Pageable pageable);
}
