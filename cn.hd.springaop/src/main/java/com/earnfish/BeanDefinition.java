package com.earnfish;

/**
 * 定义了元数据: 哪一个bean
 * 			  beanName==>bean
 * 			  beanClassName
 * 			  beanClass
 * @author dudu
 *
 */
public class BeanDefinition {
	private Object bean;
	
	private Class beanClass;
	
	private String beanClassName;

	//属性列表
	private PropertyValues propertyValues = new PropertyValues();//防止出现空的情况
	
	public PropertyValues getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(PropertyValues propertyValues) {
		this.propertyValues = propertyValues;
	}

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}

	public Class getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
		try {
			this.beanClass = Class.forName(beanClassName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
