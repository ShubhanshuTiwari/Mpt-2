package com.cg.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.product.pojo.ProductDto;
import com.cg.product.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired(required=true)
	ProductRepo productrepo;
	public List<ProductDto> findAll(){
		return productrepo.findAll() ;	
	}
	public ProductDto create(ProductDto productdto) {
		return productrepo.create(productdto);
	}
	public ProductDto get(int id) {
		return productrepo.get(id);
	}
	public ProductDto update(int id,ProductDto productdto) {
		return productrepo.update(id, productdto);
		
	}
	public ProductDto delete(int id) {
		return productrepo.delete(id);
		
	}
}
