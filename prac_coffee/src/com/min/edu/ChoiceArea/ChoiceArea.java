package com.min.edu.ChoiceArea;

import com.min.edu.coffee.Coffee;
import com.min.edu.coffee.CoffeeImpl;

public class ChoiceArea {
	
	public Coffee factory(int choice, int money) {
		Coffee item = null;
		switch (choice) {
		case 1 : new CoffeeImpl("에스프레소", 1500, 10); break;
		case 2 : new CoffeeImpl("아메리카노", 2000, 10);
		case 3 : new CoffeeImple("카페라떼", 3000, 10);
		case 4 : new CoffeeImpl("초코라떼", 3500, 10);
		
		}
		
		return choice;
	}

}
