package com.earnfish.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 当然还有其他的Resource
 * 需要一个调用者:ResourceLoader
 * @author dudu
 *
 */
public class UrlResource implements Resource {
	
	private final URL url;//从一个url中获取输入流,final
	
	public UrlResource(URL url) {
		this.url = url;
	}

	/**从url连接中获取输入流
	 * @see com.earnfish.io.Resource#getInputStream()
	 */
	public InputStream getInputStream() throws Exception {
		URLConnection urlConnection = url.openConnection();
		urlConnection.connect();//创建连接之后,获取输入流
		return urlConnection.getInputStream();
	}

}
