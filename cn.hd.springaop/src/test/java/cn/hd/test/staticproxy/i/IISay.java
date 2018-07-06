package cn.hd.test.staticproxy.i;

/**
 * 真实业务角色
 * 
 * @author dudu
 * 
 */
public class IISay implements ISay {

	public String name;
	public int age;

	public IISay() {
		super();
	}

	public IISay(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 */
	public void say(String msg) {
		System.out.println(msg + "!我是" + this.name + ",今年" + this.age + "岁!" );
	}

}
