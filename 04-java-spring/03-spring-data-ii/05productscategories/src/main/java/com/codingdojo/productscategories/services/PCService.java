package com.codingdojo.productscategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.repositories.CategoryRepo;
import com.codingdojo.productscategories.repositories.ProductRepo;

@Service
public class PCService {
	private final ProductRepo prepo;
	private final CategoryRepo crepo;
	public PCService(ProductRepo prepo, CategoryRepo crepo) {
		this.crepo =crepo;
		this.prepo = prepo;
	}
	public List<Product> getProducts() {
		return prepo.findAll();
	}
	public List<Category> getCategories() {
		return crepo.findAll();
	}
	public Product createProduct(Product p) {
		return prepo.save(p);
	}
	public Product updateProduct(Product p) {
		return prepo.save(p);
	}
	public Category createCategory(Category c) {
		return crepo.save(c);
	}
	public Product findProduct(Long id) {
		return prepo.findById(id).orElse(null);
	}
	public Category findCategory(Long id) {
		return crepo.findById(id).orElse(null);
	}
}
