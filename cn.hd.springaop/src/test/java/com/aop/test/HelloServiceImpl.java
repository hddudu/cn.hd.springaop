package com.aop.test;

/**
 * @author dudu
 *
 */
public class HelloServiceImpl implements HelloService {

	private String text;
	
	private OutputService outputService;
	
	public void helloworld() {
//		System.out.println("我进来了,准备调用outputService的 方法");
//		System.out.println(outputService);//null
		outputService.output(text);
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setOutputService(OutputService outputService) {
		this.outputService = outputService;
	}
}
