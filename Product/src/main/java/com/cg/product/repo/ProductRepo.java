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
		productdto.setId(id);
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

	@Override
	public List<ProductDto> findByPrice(int Minprice, int Maxprice) {
		// TODO Auto-generated method stub
		String selAllQuery="SELECT p FROM ProductDto p WHERE price BETWEEN :min AND :max";
		TypedQuery<ProductDto> tq=entityManager.createQuery(selAllQuery,ProductDto.class);
		tq.setParameter("min", Minprice);
		tq.setParameter("max", Maxprice);
		List<ProductDto> list=tq.getResultList();
		return list;
	}

	@Override
	public List<String> findBypType(String producttype) {
		// TODO Auto-generated method stub
		Query query=entityManager.
				createQuery("SELECT p.pName FROM ProductDto p WHERE pType=:brand");
		query.setParameter("brand", producttype);
		List<String> list=query.getResultList();
		return list;
	}
}
