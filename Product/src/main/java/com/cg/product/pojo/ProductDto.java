package com.cg.product.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name="Product")
public class ProductDto {
	
	public ProductDto() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="ProductName")
	@NotNull
	@Size(min = 2, max = 26)
	//@Size(min = 2) It is also valid
	/*@Size(min=1,message="name is required")
	@Pattern(regexp="^[A-Z]{1}[a-z]+$")*/
	private String pName;
	@Column(name="ProductType")
	private String pType;
	@Column(name="Price")
	private String price;
	
	
	
	//@Min(2) It is for integer type
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public ProductDto(int id, String pName, String pType, String price) {
		this.id = id;
		this.pName = pName;
		this.pType = pType;
		this.price = price;
	}
	
	
	
	
	
}
