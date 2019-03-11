package com.cg.product.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.product.exception.NamePatternException;
import com.cg.product.pojo.ProductDto;
import com.cg.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired(required=true)
	private ProductService serviceref;
	
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String printHello() {
		return "Hello";
	}
	
	@RequestMapping(value="/getProduct",method=RequestMethod.GET,produces="application/json")
	public ProductDto getProduct(){
		ProductDto dto=new ProductDto();
		dto.setpName("bolleyball");
		dto.setpType("Game");
		dto.setPrice(150);
		return dto;
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET,value="product")
	public List<ProductDto> findAll(){
		return serviceref.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="product")
	public ProductDto create(@RequestBody ProductDto productdto) {
		return serviceref.create(productdto);
		}
	
	@RequestMapping(method=RequestMethod.GET,value="/product/{id}")
	public ProductDto get(@PathVariable int id) {
		return serviceref.get(id);
		}
	
	@RequestMapping(method=RequestMethod.PUT,value="/product/{id}")
	public ProductDto update(@PathVariable int id,@RequestBody ProductDto productdto) {
		return serviceref.update(id, productdto);
		}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/product/{id}")
	public ProductDto delete(@PathVariable int id) {
		return serviceref.delete(id);
		}	
	
	@RequestMapping(method=RequestMethod.GET,value="/product/{minPrice}/{maxPrice}")
	public List<ProductDto> findByPrice(@PathVariable int minPrice,@PathVariable int maxPrice) {
		return serviceref.findByPrice(minPrice, maxPrice);
		}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/producttype/{pType}")
	public List<String> findBypType(@PathVariable String pType) {
		return serviceref.findBypType(pType);
		}

	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Enter corrct name.")
	@ExceptionHandler({NamePatternException.class})
	public void handleNameException() {
		
	}
	
	
}
