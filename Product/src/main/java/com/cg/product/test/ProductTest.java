package com.cg.product.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	@Before
	public void setUp() {
		System.out.println("Product object is setting up");	
	}
	
	
	@Test
	public void test() {
	/*	fail("Not yet implemented");*/
	assertTrue(true);
	}
	@After
	public void tiredDown() {
		System.out.println("Product object is tired ");
	}
	
}
