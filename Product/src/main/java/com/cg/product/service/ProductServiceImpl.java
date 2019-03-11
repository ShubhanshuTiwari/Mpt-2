package com.cg.product.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.product.exception.NamePatternException;
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
		
		
		/*
		 * String mobno=customer.getMobileNo(); Pattern
		 * pattern=Pattern.compile("^[0-9]{10}$"); Matcher mat=pattern.matcher(mobno);
		 * if(mat.matches()==false) throw new InvalidMobileException();
		 * 
		 * 
		 * String email=customer.getEmail(); Pattern emailPat=Pattern.compile(
		 * "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
		 * ); Matcher emailmat=emailPat.matcher(email); if(emailmat.matches()==false)
		 * throw new InvalidEmailException();
		 * 
		 * String fname=customer.getFirstName();
		 *  
		 *Pattern namePat=Pattern.compile("[A-Z][a-zA-Z]*"); 
		 * Matcher nameMa=namePat.matcher(fname); if(nameMa.matches()==false) throw new
		 * InvalidNameException(); String lName=customer.getLastName(); Matcher
		 * nameMat=namePat.matcher(lName); if(nameMat.matches()==false) throw new
		 * InvalidNameException();
		 */
	
		
		
		
		String name=productdto.getpName();
		Pattern namePat=Pattern.compile("[A-Z][a-zA-Z]*"); 
		Matcher nameMa=namePat.matcher(name);
		if(nameMa.matches()==false) {
		throw new NamePatternException();
		}
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
	public List<ProductDto> findByPrice(int Minprice, int Maxprice) {
		// TODO Auto-generated method stub
		return productrepo.findByPrice(Minprice, Maxprice);
	}
	public List<String> findBypType(String ptype) {
		// TODO Auto-generated method stub
		return productrepo.findBypType(ptype);
	}
}
