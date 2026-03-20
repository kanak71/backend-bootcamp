package com.min.edu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2_Main {

	public static void main(String[] args) {
		// Log4j를 사용하는 방법
		Logger log = LogManager.getLogger(Log4j2_Main.class); //메모리에서 영역을 위한 Class를 지정
		log.info("log4j 로그 level info");
	}

}
