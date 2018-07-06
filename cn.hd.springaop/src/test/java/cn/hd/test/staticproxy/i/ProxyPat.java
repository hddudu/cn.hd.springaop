package cn.hd.test.staticproxy.i;

/**
 * 测试类
 * @author dudu
 *
 */
public class ProxyPat {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ISay isayer = new IISay("earyAOP", 18);
		isayer.say("No Proxy Ts");
		
		//需要执行额外的方法
		ProxyISay pis = new ProxyISay(isayer);
		pis.say("ProxyTest", "🍎 ");
	}
}
