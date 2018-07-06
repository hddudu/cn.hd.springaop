package com.aop.test;

public class OutputServiceImpl implements OutputService {

	public void output(String text) {
		System.out.println("输出: " + text);
	}

}
