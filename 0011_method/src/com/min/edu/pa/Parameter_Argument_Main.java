package com.min.edu.pa;

import java.util.Scanner;

public class Parameter_Argument_Main {

	//TODO 102 메소드에서 필요한 값을 전달한다 Argument
	public static void main(String[] args) {
		
		Parameter_Argument pa = new Parameter_Argument();
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		pa.make_method(str);

	}

}
