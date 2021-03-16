package com.codingdojo.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.services.PCService;

@Controller
public class PCController {
	private final PCService pcservice;
	public PCController (PCService pcservice) {
		this.pcservice = pcservice;
	}
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("product", pcservice.getProducts());
		return "index.jsp";
	}
	@RequestMapping("/product/new")
	public String newProduct(@ModelAttribute("product")Product product) {
		return "/product/newproduct.jsp";
	}
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "product/newproduct.jsp";
		}
		else {
			pcservice.createProduct(product);
			return "redirect:/";
		}
	}
	@RequestMapping("/category/new")
	public String newCategory(@ModelAttribute("category")Category category) {
		return "/category/newcategory.jsp";
	}
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "category/newcategory.jsp";
		}
		else {
			pcservice.createCategory(category);
			return "redirect:/";
		}
	}
	@RequestMapping("/product/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model, @ModelAttribute("product")Product Product) {
		model.addAttribute("product", pcservice.findProduct(id));
		List<Category> categories = pcservice.getCategories();
		model.addAttribute("categories", categories);
		return "/product/showproduct.jsp";
	}
	@PostMapping("/product/{id}")
	public String attachcategory(@RequestParam("categories")Long catId, @PathVariable("id") Long id) {
		//get product
		Product product = pcservice.findProduct(id);
		//get category
		List<Category> categoriesp = product.getCategories();
		//set category
		Category categoryId = pcservice.findCategory(catId);
		categoriesp.add(categoryId);
		//update product with category
		pcservice.updateProduct(product);
		return "redirect:/";
	}
	/*@RequestMapping(path="/product/{id}", method = RequestMethod.GET)
	public String addCategory(@ModelAttribute("product")Product product, Model model) {
		List<Category> categories = pcservice.getCategories();
		model.addAttribute("categories", categories);
		return "/product/showproduct.jsp";
	}
	/*@RequestMapping("/category/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("category", pcservice.findCategory(id));
		return "/product/showproduct.jsp";
	}
	@RequestMapping("/category/{id}")
	public String addProduct(@ModelAttribute("category")Category category, Model model) {
		List<Product> products = pcservice.getProducts();
		model.addAttribute("products", products);
		return "/category/showcategory.jsp";
	}*/
}
