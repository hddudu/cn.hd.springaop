package com.earnfish.aop;

/**
 * AopProxy是个标志型接口
 * 暴露获取aop代理对象方法的接口
 * @author dudu
 *
 */
public interface AopProxy {
	/**
	 * 获取代理对象
	 * @return
	 * @throws Exception
	 */
	Object getProxy() throws Exception;
}
