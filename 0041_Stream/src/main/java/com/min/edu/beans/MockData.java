package com.min.edu.beans;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.min.edu.dto.Car;
import com.min.edu.dto.People;

//TODO 001 json 파일을 IO로 읽고 GSON을 통해서 java의 객체로 변환
public class MockData {
	
	public static List<People> getPeople() throws IOException {
		//1) 1단계 파일에서 commons io를 통해 해당 위치의 파일을 010101... 로 읽어온다
		InputStream inputStream = 
				Resources.getResource("com/min/edu/resources/people.json").openStream();
		
		//2) 2단계 읽어온 데이터를 문자열로 변경한다
		String json = IOUtils.toString(inputStream,StandardCharsets.UTF_8);
		
		//3) 읽어온 문자열을 List 타입으로 변경
		Type listType = new TypeToken<ArrayList <People>>() {}.getType();
		return new Gson().fromJson(json, listType);
		
	}
	
	public static List<Car> getCar() throws IOException {
		//1) 1단계 파일에서 commons io를 통해 해당 위치의 파일을 010101... 로 읽어온다
		InputStream inputStream = 
				Resources.getResource("com/min/edu/resources/cars.json").openStream();
		
		//2) 2단계 읽어온 데이터를 문자열로 변경한다
		String json = IOUtils.toString(inputStream,StandardCharsets.UTF_8);
		
		//3) 읽어온 문자열을 List 타입으로 변경
		Type listType = new TypeToken<ArrayList <Car>>() {}.getType();
		return new Gson().fromJson(json, listType);
		
	}

}
