package com.min.prac;

public class RollBook {
	
	public Student call() {
		return directory();
	}
	
	public Student directory() {
		Student me = new Student();
		me.name = "전민균";
		me.age = "10";
		me.address = "서울";
		return me;
	}

}
