package com.product.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.bean.Product;
@Repository
public interface IProductRepo extends JpaRepository<Product, String> {
	
//	
//	@Query("from Product where id=:d")
//	void deleteById(@Param("d")String id);
//
//	
//	@Query("from Product where id=:s")
//	Optional<Product> findById(@Param("s")String id);
	
	

}
