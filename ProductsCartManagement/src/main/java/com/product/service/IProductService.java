package com.product.service;

import java.util.List;

import com.product.bean.Product;
import com.product.exception.ProductException;

public interface IProductService {

	public List<Product> createProduct(Product pro) throws ProductException;
	public Product getProductById(String id) throws ProductException;
	public void deleteProduct (String id) throws ProductException;
	public List<Product> getAllProducts() throws ProductException;
	public List<Product> updateProduct(String id, Product bo) throws ProductException;
	
	
}
