package com.min.edu;

public class Coffee {
	private String kindCoffee;
	private String water;
	private boolean sirup;
	private boolean cream;
	
	//생성자는 Builder를 통해서만 호출
	public Coffee(CoffeeBuilder builder) {
		this.kindCoffee = builder.kindCoffee;
		this.water = builder.water;
		this.sirup = builder.sirup;
		this.cream = builder.cream;
	}
	
	public static class CoffeeBuilder{
		private String kindCoffee;
		private String water;
		private boolean sirup;
		private boolean cream;
		
		//필수 값은 생성자에서 입력
		public CoffeeBuilder(String kindCoffee, String water) {
			this.kindCoffee = kindCoffee;
			this.water = water;
		}
		
		//선택 값은 setter를 통해서 설정
		public CoffeeBuilder setSirup(boolean sirup) {
			this.sirup = sirup;
			return this;	//메서드 체이닝
		}
		
		public CoffeeBuilder setCream(boolean cream) {
			this.cream = cream;
			return this;
		}
		
		//최종 객체 생성
		public Coffee build() {
			return new Coffee(this);
		}
		
	}

	//디버깅용 toString
	@Override
	public String toString() {
		return "Coffee [kindCoffee=" + kindCoffee + ", water=" + water + ", sirup=" + sirup + ", cream=" + cream + "]";
	}
	
	
	
	

}
