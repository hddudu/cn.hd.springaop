package com.earnfish.context;

import java.util.List;



import com.earnfish.BeanDefinition;
import com.earnfish.BeanPostProcessor;
import com.earnfish.factory.AbstractBeanFactory;

/**
 * @author dudu
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

	private AbstractBeanFactory beanFactory;//抽象工厂
	
	public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
	
	/**
	 * @see com.earnfish.factory.BeanFactory#getBean(java.lang.String)
	 */
	public Object getBean(String name) throws Exception {
		return beanFactory.getBean(name);
	}

	/**
	 * 用于实现 BeanFactory的刷新,也就是告诉 BeanFactory 该使用哪个资源 （resource）加载bean的定义,
	 * 并实例化，初始化bean
	 * @throws Exception
	 */
	public void refresh() throws Exception {
		loadBeanDefinitions(beanFactory);//通过beanfactory工厂加载
		// 从 BeanFactory 中的bean的定义找实现 BeanPostProcessor接口的类(例如：AspectJAwareAdvisorAutoProxyCreator.java)
		// 注册到 AbstractBeanFactory 维护的 BeanPostProcessor 列表中去(用于在bean实例化后对其进行一些其他处理，
		// 可以看看getBean方法()中的initializeBean()的调用)。 
		// 后面调用getBean方法通过AspectJAwareAdvisorAutoProxyCreator#postProcessAfterInitialization()方法中调用了
		// getBeansForType方法保证了 PointcutAdvisor 的实例化顺序优于普通 Bean。
		
		registerBeanPostProcessors(beanFactory);//完成切面处理程序
		
		onfresh();//
	}
	
	/**
	 * 实现支持单例类型的bean
	 * @throws Exception
	 */
	protected void onfresh() throws Exception {
		beanFactory.preInstantiateSingletons();
	}

	/**
	 * 切入的是列表：
	 * 	前置不变
	 * 		中间是列表形式
	 * 	后置不变
	 * 可以用于实例化AspectJAwareAdvisorAutoProxyCreator : 用于代理切面代理
	 * @param beanFactory
	 */
	protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception {
		List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
		for(Object beanPostProcessor : beanPostProcessors) {
			beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
		}
	}

	/**
	 * 由子类决定从哪种形式的Resource中加载出bean的定义,并保存到beanFactory中
	 * 可以从xml中、也可以直接就从文件中
	 * @param beanFactory
	 */
	protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

	/**留给具体的加载资源类实现
	 * @see com.earnfish.factory.BeanFactory#registerBeanDefinition(java.lang.String, com.earnfish.BeanDefinition)
	 */
	public void registerBeanDefinition(String name,
			BeanDefinition beanDefinition) throws Exception {
		
	}

}
