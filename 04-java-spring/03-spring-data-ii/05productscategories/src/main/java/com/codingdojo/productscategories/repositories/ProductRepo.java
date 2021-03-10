package com.codingdojo.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;

public interface ProductRepo extends CrudRepository <Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category); //why?
}
