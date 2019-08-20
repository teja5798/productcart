package com.product.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.bean.Product;
import com.product.exception.ProductException;
import com.product.service.IProductService;

@RestController
public class ProductController {
	@Autowired
	IProductService productService;
	
	@RequestMapping("/products")
	public List <Product> getAllProductss() throws ProductException
	{
		return productService.getAllProducts();
	}
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public List<Product> createBook(@RequestBody Product pro) throws ProductException{
		return productService.createProduct(pro);
			}
	
	@RequestMapping("/products/{id}")
	public Product getProductById(@PathVariable String id) throws ProductException{
	return productService.getProductById(id);
    }
	

	@DeleteMapping("/products/{id}")	
	public ResponseEntity<String> deleteProduct(@PathVariable String id) throws ProductException {
		productService.deleteProduct(id);
	return new ResponseEntity<String> ("Product with id "+id+" deleted successfullyy",HttpStatus.OK);
	}
	
	@PutMapping("/products/{id}")
	public List <Product> updateProduct(@PathVariable String id, @RequestBody Product pro) throws ProductException{
		return productService.updateProduct(id, pro);
	}
	
}