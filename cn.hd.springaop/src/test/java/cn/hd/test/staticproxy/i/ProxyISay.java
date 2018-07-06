package cn.hd.test.staticproxy.i;

/**
 * 代理对象
 * @author dudu
 *
 */
public class ProxyISay implements ISay {
	
	private ISay isayer;//就是代理类中内聚了（内含）真实对象

	public ProxyISay(ISay isayer) {
		this.isayer = isayer;
	}
	
	public void say(String msg) {
		isayer.say(msg);
	}
	
	/**
	 * 说话：聊天,然后吃水果
	 * @param msg
	 * @param fruit
	 */
	public void say(String msg, String fruit) {
		say(msg);//连接点： 具体的逻辑位置
		//系统逻辑
		eat(fruit);
	}
	
	//接下来是在代理类中添加系统逻辑（这里处理为本类方法类）
	private void eat(String fruit) {
		System.out.println("吃: " + fruit);
	}
}
