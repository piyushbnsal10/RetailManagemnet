package com.via.RetailManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("*")
@RequestMapping(path="/api")
public class ProductsController {

	@Autowired
	ProductsRepo productsRepo;
	
	@RequestMapping(path="/products" , method=RequestMethod.POST)
	public ResponseEntity<Void> addCourse(@RequestBody Products products){
		productsRepo.save(products);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/products/{pId}" , method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("pId") int pId){
		productsRepo.deleteById(pId);
	}
	
	@RequestMapping(path="/products",method=RequestMethod.GET)
	public List<Products> findAllProducts()
	{
		List<Products> products= productsRepo.findAll();
		return products;
	}
	
	@RequestMapping(path="/products/{title}", method=RequestMethod.GET)
	public ResponseEntity<Products> findProductsByTitle(@PathVariable("title") String title)
	{
		Products products =productsRepo.findByTitle(title);
		ResponseEntity<Products> re = null;
		if(products == null){
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return re;
		}
		re = new ResponseEntity<>(products, HttpStatus.OK);
		return re;
	}
	
	@RequestMapping(path="/products/{category}", method=RequestMethod.GET)
	public ResponseEntity<Products> findProductsByCategory(@PathVariable("category") String category)
	{
		Products products =productsRepo.findByCategory(category);
		ResponseEntity<Products> re = null;
		if(products == null){
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return re;
		}
		re = new ResponseEntity<>(products, HttpStatus.OK);
		return re;
	}
}
