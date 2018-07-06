package cn.hd.test.staticproxy.i;

import java.lang.reflect.Method;

public class Vendor implements Sell {

	private static Method mm = Vendor.class.getMethods()[0];
	
	public void sell() {
		System.out.println("In sell method");
	}

	public void advise() {
		System.out.println("advise method");
	}

}
