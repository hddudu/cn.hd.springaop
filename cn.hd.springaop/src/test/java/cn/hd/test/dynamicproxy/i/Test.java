package cn.hd.test.dynamicproxy.i;

import cn.hd.test.staticproxy.i.IISay;
import cn.hd.test.staticproxy.i.ISay;

/**
 * @author dudu
 *
 */
public class Test {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 绑定代理，这种方式会在所有的方法都加上切面方法
		ISay isayer = (ISay) new DynamicProxy().bind(new IISay("林青霞",20));
		isayer.say("业务说明");
	}
}
