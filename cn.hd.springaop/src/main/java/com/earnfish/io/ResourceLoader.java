package com.earnfish.io;

import java.net.URL;

/**
 * @author dudu
 *
 */
public class ResourceLoader {
	
	/**
	 * 根据路径获取一个资源的输入流
	 * @param location
	 * @return
	 */
	public Resource getResource(String location) {
		URL url = this.getClass().getClassLoader().getResource(location);
		//file:/F:/myFrame/cn.hd.springaop%20Maven%20Webapp/target/classes/tinyioc.xml
		return new UrlResource(url);
	}
}
