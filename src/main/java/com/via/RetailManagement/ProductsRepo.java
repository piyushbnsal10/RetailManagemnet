package com.via.RetailManagement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepo extends JpaRepository<Products, Integer>{
	
	public Products findByTitle(String title);
	
	public Products findByCategory(String Category);

}
