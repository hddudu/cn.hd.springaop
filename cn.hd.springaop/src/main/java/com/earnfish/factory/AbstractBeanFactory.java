package com.earnfish.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.earnfish.BeanDefinition;
import com.earnfish.BeanPostProcessor;

/**
 * 抽象类主要用来： 抽线类主要用来做模板，它内部定义了一些模板，也实现了一些模板，也抽象了一些模板，它无法实例化
 * 	这里就类似于模板方法模式
 * @author dudu
 *
 */
public abstract class AbstractBeanFactory implements BeanFactory {

	//并不一定线程安全的?为什么?
	private Map<String, BeanDefinition> beanDefinitionMap 
		= new ConcurrentHashMap<String, BeanDefinition>();
	
	private final List<String> beanDefinitionNames = new ArrayList<String>();
	
	/**
	 * 增加bean处理程序,完成切面编程
	 * 例如通过AspectJAwareAdvisorAutoProxyCreator#postProcessAfterInitialization()实现AOP的织入
	 */
	private List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();
	
	/**直接返回bean: 从容器map中获取
	 * @see com.earnfish.factory.BeanFactory#getBean(java.lang.String)
	 */
	public Object getBean(String name) throws Exception {
		BeanDefinition beanDefinition = beanDefinitionMap.get(name);//获取元数据实体
		if(beanDefinition == null) {
			throw new IllegalArgumentException("No bean named " + name + " is defined");
		}
		Object bean = beanDefinition.getBean();//获取具体的bean
		if(bean == null) {
			bean = doCreateBean2(beanDefinition);//解析进行真实注入bean
			//初始化bean
			//例如，生成相关代理类，用于实现AOP织入
			bean = initializeBean(bean, name);
			beanDefinition.setBean(bean);//又进行设置元数据： 将完成注入后的bean设置到元数据中
		}
		return bean;
//		return beanDefinitionMap.get(name).getBean();
	}

	/**
	 * @param bean
	 * @param name
	 * @return
	 * @throws Exception 
	 */
	protected Object initializeBean(Object bean, String name) throws Exception {
		for(BeanPostProcessor beanPostProcessor : beanPostProcessors) {
			bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
		}
		// 可以看看AutowireCapableBeanFactory的postProcessAfterInitialization()方法实现
		// 返回的可能是代理对象
		for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
		}
		return bean;
	}

	/**注册： 就是把name加入到map当中去
	 * @see com.earnfish.factory.BeanFactory#registerBeanDefinition(java.lang.String, com.earnfish.BeanDefinition)
	 */
	public void registerBeanDefinition(String name,
			BeanDefinition beanDefinition) throws Exception {
		//因为我们是根据元数据先生成BeanDefinition,然后再将其注册到map中
//		Object bean = doCreateBean(beanDefinition);
//		beanDefinition.setBean(bean);
		this.beanDefinitionMap.put(name, beanDefinition);//为什么不直接这么做呢?
		beanDefinitionNames.add(name);
	}

	/**
	 * 循环实例化
	 * @throws Exception
	 */
	public void preInstantiateSingletons() throws Exception {
		for(Iterator it = this.beanDefinitionNames.iterator();it.hasNext();) {
			String beanName = (String) it.next();
			getBean(beanName);
		}
	}
	
	/**
	 * 等待子类实现,初始化bean的时候，进行解析和真实bean的注入
	 * @param bean
	 * @param beanDefinition
	 * @throws Exception
	 */
	protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
		
	}
	
	/**
	 * @param beanDefinition
	 * @return
	 * @throws Exception
	 */
	protected Object doCreateBean2 (BeanDefinition beanDefinition) throws Exception {
		Object bean = createBeanInstance(beanDefinition);
		beanDefinition.setBean(bean);//注入实例bean
		//进行解析和真实bean的注入
		applyPropertyValues(bean, beanDefinition);//将实例注入到beanDefinition中
		return bean;
	}
	
	/**
	 * @param beanDefinition
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	protected Object createBeanInstance(BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException {
		return beanDefinition.getBeanClass().newInstance();
	}

	/**
	 * 根据元数据实例化一个BeanDefinition
	 * 具体怎么做待实现
	 * @param beanDefinition
	 * @return
	 */
	abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

	/**
	 * 仅仅用来做测试
	 * @return
	 */
	public Map<String, BeanDefinition> getBeanDefinitionMap() {
		return beanDefinitionMap;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public List getBeansForType(Class type) throws Exception {
		List beans = new ArrayList<Object>();
		for(String beanDefinitionName : beanDefinitionNames) {
			/*
			 *  判断此Class 对象所表示的类 与 指定的 Class参数所表示的类是否相同，或者是否是其父类
			 */
			if(type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
				//将同类的beanDefinition加入到列表中
				beans.add(getBean(beanDefinitionName));
			}
		}
		return beans;
	}
	
	/**
	 * 增加bean处理程序
	 * @throws Exception
	 */
	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws Exception {
		this.beanPostProcessors.add(beanPostProcessor);
	}
	
}
