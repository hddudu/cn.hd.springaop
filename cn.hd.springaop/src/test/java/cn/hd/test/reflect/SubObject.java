package cn.hd.test.reflect;

/**
 * @author dudu
 *
 */
public class SubObject extends BaseObject {

	@Override
	public void getObjectName() {
		System.out.println("SubObject");
	}
	
	public void getParametersLength(String...params) {
		System.out.println("param's length is: " + params.length);
	}
	
	public void getParametersLength(String param1, String param2) {
		System.out.println(param1 + "-" + param2);
	}
	
}
