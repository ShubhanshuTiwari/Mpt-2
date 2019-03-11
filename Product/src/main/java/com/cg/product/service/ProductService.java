package com.cg.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.product.pojo.ProductDto;
@Service
public interface ProductService {

	public List<ProductDto> findAll();
	public ProductDto create(ProductDto productdto);
	public ProductDto get(int id);
	public ProductDto update(int id,ProductDto productdto);
	public ProductDto delete(int id);
	public List<ProductDto> findByPrice(int Minprice,int Maxprice);
	public List<String> findBypType(String ptype);
	
}
