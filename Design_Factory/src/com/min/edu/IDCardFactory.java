package com.min.edu;

import java.util.ArrayList;
import java.util.List;

//TODO 004 실제 IDCard를 만들고, 만들어진 객체를 목록 저장
public class IDCardFactory extends Factory {
	
	private List<Product> owners = new ArrayList<Product>();

	@Override
	public Product createProduct(String owner) {
		return new IDCard(owner);
		
	}

	@Override
	public void registProduct(Product product) {
		owners.add(product);

	}

	public List<Product> getOwners() {
		return owners;
	}
	
	

}
