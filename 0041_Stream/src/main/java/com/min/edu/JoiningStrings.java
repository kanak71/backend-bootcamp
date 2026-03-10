package com.min.edu;

import java.util.List;
import java.util.stream.Collectors;

//{코코아=2, 홍길동=2, 알렉스=1} : 객체를 출력해서 toString() 오버라이딩 해서, 가독성 출력
public class JoiningStrings {
	
	public static void main(String[] args) {
		List<String> names = List.of("anna", "john", "macro", "helena");
		
		StringBuffer join = new StringBuffer();
		
		for (String name : names) {
			join.append(name.substring(0, 1).toUpperCase()).append(name.substring(1)).append(", ");
			
		}
		System.out.println(join);
		System.out.println(join.substring(0,join.length()-2));
		
		String joinStream = names.stream()
				.map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
				.collect(Collectors.joining("|"));
		System.out.println(joinStream);
	}

}
