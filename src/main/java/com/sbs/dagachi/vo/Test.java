package com.sbs.dagachi.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {
	
	private int tno;
	private String title;
	private String content;
	private String name;
	private int status;
	private Date date;
	private int type;
	private int progress;
	private int delstatus;
	
}
