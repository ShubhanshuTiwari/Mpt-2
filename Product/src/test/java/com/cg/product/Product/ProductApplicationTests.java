package com.cg.product.Product;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.product.pojo.ProductDto;
import com.cg.product.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductApplicationTests {

	@Autowired
	private ProductService serRef;
	
	@Before
	public void setUp() {
		System.out.println("Product object is setting up");
	
	}
	
	
	@Test
	public void contextLoads() {
		boolean flag=true;
		List<ProductDto> list=serRef.findAll();
		flag=list.isEmpty();
		System.out.println(list);
		assertFalse(flag);;
	}
	
	
	@After
	public void tiredDown() {
		System.out.println("Product object is tired down");
	}
	
	

}
