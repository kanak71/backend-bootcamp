package com.min.edu.step03;

public class BoxImpl<T> implements Generic_Interface<T> {
	
	private T myBox;

	@Override
	public void store(T t) {
		myBox = t;
	}

	public T getMyBox() {
		return myBox;
	}
	

}
