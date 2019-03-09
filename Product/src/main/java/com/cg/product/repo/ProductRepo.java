package com.cg.product.repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.product.pojo.ProductDto;

@Repository
@Transactional
public class ProductRepo implements IProductRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<ProductDto> findAll() {
		// TODO Auto-generated method stub
		
		TypedQuery<ProductDto> query=entityManager.createQuery("select prod from ProductDto prod ", ProductDto.class);
						
					List<ProductDto> list= query.getResultList();
					System.out.println("inside find all:"+list);
				return list;
		/*Query query= entityManager.createQuery(" select * from Product");
		return query.getResultList();*/
		
	}

	@Override
	@Transactional
	public ProductDto create(ProductDto productdto) {
		// TODO Auto-generated method stub
		
		 entityManager.persist(productdto);
		 return productdto;
	}

	@Override
	@Transactional
	public ProductDto get(int id) {
		// TODO Auto-generated method stub
		ProductDto productdto= entityManager.find(ProductDto.class, id);
		return productdto;
	}

	@Override
	@Transactional
	public ProductDto update( int id,ProductDto productdto) {
		// TODO Auto-generated method stub
		
		entityManager.merge(productdto);
		entityManager.flush();
		return productdto;
	/*	ProductDto productdtoref=entityManager.find(ProductDto.class,id);
		entityManager.remove(productdtoref);
		entityManager.persist(productdto);
		
		return productdto;*/
	}

	@Override
	@Transactional
	public ProductDto delete(int id) {
		// TODO Auto-generated method stub
		/* entityManager.remove(id);*/
		ProductDto product= entityManager.find(ProductDto.class, id);
		entityManager.remove(product);
		entityManager.flush();
		return product;
		 
	}
	
	
	
	
	
	
	
	
	
}
