package com.cg.product.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.product.pojo.ProductDto;
import com.cg.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired(required=true)
	private ProductService serviceref;
	
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
}
