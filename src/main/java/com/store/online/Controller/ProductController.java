package com.store.online.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.online.POJO.Product;
import com.store.online.Service.ProductService;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	/**
	 * to find Application is available
	 * @return
	 */
	@GetMapping(value = "/ping")
	public String applicationAvailable() {
		logger.debug("Ping Succeeded");
		return "Success";
	}
	
	/**
	 * Adding or updating products in to the db
	 * @param token
	 * @param product
	 * @return
	 */
	@PostMapping(path = "/createOrUpdate", consumes = "application/json")
	public boolean addOrUpdateProducts(@RequestBody Product product) {
		logger.debug("addOrUpdateProducts");
		return productService.addOrUpdateProducts(product);
	}
	/*
	 * Delete the product details
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public boolean deleteProducts(@PathVariable int id) {
		logger.debug("deleteProducts");
		return productService.deleteProduct(id);
	}
	/**
	 * @param product
	 * @return
	 */
	@GetMapping("/fetch")
	public List<Product> getProducts(@RequestBody Product product) {
		logger.debug("getProducts");
		return productService.getProducts(product);
	}

}
