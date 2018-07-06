package com.reflect.demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * 操作属性文件
 * @author dudu
 *
 */
public class Init {

	/**
	 * @return
	 * @throws Exception
	 */
	public static Properties getProperties() throws Exception {
		Properties properties = new Properties();
		File file = new File("fruit.properties");
		System.out.println(file.getAbsolutePath());
		if(file.exists()) {
			properties.load(new FileInputStream(file));
			System.out.println(properties);
			System.out.println("---");
		} else {
			System.out.println("=========");
			properties.setProperty("apple", "com.reflect.demo2.Apple");
			properties.setProperty("orange", "com.reflect.demo2.Orange");
			properties.store(new FileOutputStream(file), "FRUIT CLASS");
			//与load方法相反，将Properties表中的属性列表写入到输出流文件中
		}
		return properties;
	}
}
