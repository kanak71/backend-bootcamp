package com.min.edu.step04;

public class Generic_Step04_Main {

	public static void main(String[] args) {
		
		FruitBox banana = new FruitBox();
		banana.name = "바나나";
		
		FruitChoice<FruitBox> choice = new FruitChoice<FruitBox>(banana);
		System.out.println("담겨 있는 과일은? :" + choice.getFruitName());
	}

}
