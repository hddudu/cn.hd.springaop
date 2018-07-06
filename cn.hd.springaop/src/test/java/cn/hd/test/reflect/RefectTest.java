package cn.hd.test.reflect;

import java.lang.reflect.Method;

/**
 * @author dudu
 *
 */
public class RefectTest {
	
	private static final String BASE_OBJECT_PATH = "cn.hd.test.reflect.BaseObject";
	private static final String SUB_OBJECT_PATH  = "cn.hd.test.reflect.SubObject";
	
	public static void main(String[] args) throws Exception {
		Class<?> pClazz = Class.forName(BASE_OBJECT_PATH);
		Class<?> cClazz = Class.forName(SUB_OBJECT_PATH);
		
		Object pObj = pClazz.newInstance();
		Object cObj = cClazz.newInstance();
		
		//1.反射调用子类父类的重载方法  
        //多态+动态绑定  
		Method pMethod = pClazz.getDeclaredMethod("getObjectName");
		pMethod.invoke(cObj, null);//
		pMethod.invoke(pObj, null);//
		
		System.out.println("---------------------");
		
		Method cMethod = cClazz.getDeclaredMethod("getObjectName", null);
		//不符合多态和动态绑定 
		cMethod.invoke(cObj, null);
//		cMethod.invoke(pObj, null);//报错的
		
		//2.反射调用可变参数的方法
		Method changeMethod = cClazz.getDeclaredMethod("getParametersLength", String[].class);
		//可变参数必须这样封装，因为java反射内部实现做了参数个数为1的判断，如果参数长度不为1，则会抛出异常 
		String[] strParams = {"a", "b", "c"};
		Object[] oParams = {strParams};
		changeMethod.invoke(cObj, oParams);
		
		//3.反射调用固定长度参数的方法  
		Method unchangeMethod = cClazz.getDeclaredMethod("getParametersLength", String.class, String.class);
		unchangeMethod.invoke(cObj, "hello", "java");
		
		Class<?>[] clazzs = {String.class,String.class};
		Method unChangeMethod2 = cClazz.getDeclaredMethod("getParametersLength", clazzs);  
        unChangeMethod2.invoke(cObj, "Hello","Java"); 
	}
	
}
