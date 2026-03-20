package com.min.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logback_Main {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Logback_Main.class);
		log.warn("logback 사용자 로그 처리");

	}

}
