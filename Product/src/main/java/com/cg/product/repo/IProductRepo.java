package com.cg.product.repo;

import java.util.List;

import com.cg.product.pojo.ProductDto;

public interface IProductRepo {

	public List<ProductDto> findAll();
	public ProductDto create(ProductDto productdto);
	public ProductDto get(int id);
	public ProductDto update(int id,ProductDto productdto);
	public ProductDto delete(int id);
}
