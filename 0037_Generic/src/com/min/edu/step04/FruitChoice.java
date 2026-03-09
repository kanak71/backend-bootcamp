package com.min.edu.step04;

public class FruitChoice <T extends FruitBox> {
	
	private T box;
	
	public FruitChoice(T t) {
		box = t;
	}
	
	public String getFruitName() {
		return box.name;
	}

}
