package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.bean.Product;
import com.product.dao.IProductRepo;
import com.product.exception.ProductException;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	IProductRepo productRepo;	
	
	@Override
	public List<Product> createProduct(Product pro) throws ProductException {
		try {
			 productRepo.save(pro);
		        return productRepo.findAll();
		        }catch(Exception e) {
		            throw new ProductException(e.getMessage());
		        }
	}

	
	@Override
	public Product getProductById(String id) throws ProductException {
		try
		{
			return productRepo.findById(id).get();
		}
		catch (Exception ex)
		{
			throw new ProductException(ex.getMessage());
		}
		
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		try
		{
			return productRepo.findAll();
		}
		catch(Exception e)
		{
			throw new ProductException(e.getMessage());
		}
	}

	@Override
	public List<Product> updateProduct(String id, Product pro) throws ProductException {
		try
		{
			Optional<Product> optional=productRepo.findById(id);
			if(optional.isPresent())
			{
				Product product=optional.get();
				product.setName(pro.getName());
				product.setModel(pro.getModel());
				product.setPrice(pro.getPrice());
				productRepo.save(product);
				return getAllProducts();
			}
			else
			{
				throw new ProductException("Product with Id"+id+" is not  existing please enter an valid id ");	
			}
		}
			catch(Exception e) {
	            throw new ProductException(e.getMessage());
			
	}
	}


	@Override
	public void deleteProduct(String id) throws ProductException {
		try
		{
			productRepo.deleteById(id);
		}
		catch(Exception e)
		{
			throw new ProductException(e.getMessage());
		}
		
	}
	
	
}



