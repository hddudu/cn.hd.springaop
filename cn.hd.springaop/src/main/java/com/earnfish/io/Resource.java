package com.earnfish.io;

import java.io.InputStream;

/**
 * 获取输入流: 用于定义不同的资源文件
 * 用于定义获取资源
 * @author dudu
 *
 */
public interface Resource {
	/**获取资源**/
	InputStream getInputStream() throws Exception;
}
