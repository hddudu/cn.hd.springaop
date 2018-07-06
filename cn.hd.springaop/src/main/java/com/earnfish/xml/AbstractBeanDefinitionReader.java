package com.earnfish.xml;

import java.util.HashMap;
import java.util.Map;

import com.earnfish.BeanDefinition;
import com.earnfish.BeanDefinitionReader;
import com.earnfish.io.ResourceLoader;

/**
 * 实现了BeanDefinitionReader接口的抽象类，未具体实现loadBeanDefinitions，而是规范了
 * BeanDefinitionReader的基本结构
 * @author dudu
 * 
 * 定义了模板，基本定义了模板结构
 *
 */
public abstract class AbstractBeanDefinitionReader implements
		BeanDefinitionReader {
	/**
	 * 通过String - BeanDefinition 键值对保存了IOC容器里的类定义
	 */
	private Map<String, BeanDefinition> registry;

	/**
	 * 资源加载器
	 */
	private ResourceLoader resourceLoader;
	
	/**
	 * 抽象类的构造器
	 * @param resourceLoader
	 */
	public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
		this.registry = new HashMap<String, BeanDefinition>();
		this.resourceLoader = resourceLoader;
	}

	public Map<String, BeanDefinition> getRegistry() {
		return registry;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}
}
