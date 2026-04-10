package com.min.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class AnswerboardDto {

	private int seq;
	private String id;
	private String title;
	private String content;
	private int ref;
	private int step;
	private int depth;
	private String regdate;
	private String delflag;
	private int readcount;

}
