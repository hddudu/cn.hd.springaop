package com.earnfish;

/**
 * 解析BeanDefinition的接口
 * 暴露加载bean定义的方法
 * ================>职责分离，从不同的地方获取资源有不同的实现，
 * 	比如说快递公司有很多个，
 * @author dudu
 *
 */
public interface BeanDefinitionReader {
	/**
	 * 根据地址加载bean的定义
	 * @param location
	 * @throws Exception
	 */
	void loadBeanDefinitions(String location) throws Exception;
}
