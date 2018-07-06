package com.earnfish.factory;

import java.lang.reflect.Field;

import com.earnfish.BeanDefinition;
import com.earnfish.BeanReference;
import com.earnfish.PropertyValue;

public class AutoWireCapableBeanFactory extends AbstractBeanFactory {
	
	@Override
	protected void applyPropertyValues(Object bean,
			BeanDefinition beanDefinition) throws Exception {
		for(PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
			//字段注入
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
			//
			declaredField.setAccessible(true);
			
			Object value = propertyValue.getValue();//value是什么呢?属性值:表示为参数
//			System.out.println("value111具体是什么东西: " + value);
			if(value instanceof BeanReference) {
				BeanReference beanReference = (BeanReference) value;
//				System.out.println(beanReference.getName());//outputService
				value = getBean(beanReference.getName());
//				System.out.println("333 : " + value);
			}
//			System.out.println("value222具体是什么东西: " + value);
//			System.out.println("bean具体是什么东西: " + bean);
/*
 * public void set(Object obj,Object value) 
 * throws IllegalArgumentException, IllegalAccessException
 将指定对象变量上此 
	        Field
对象表示的字段设置为指定的新值。
如果底层字段的类型为基本类型，则对新值进行自动解包。 
			 */
	       
			declaredField.set(bean, value);
//			System.out.println("---" + bean + " 设置的啥啊: " + declaredField.get(bean));
			/*
 	public void setBean(Object bean) {
		this.bean = bean;
	}
			 */
			try {
				
				
				
				//这个bean已经是一个对象实例
//				Method declaredMethod = bean.getClass().getDeclaredMethod(
//						"set" + propertyValue.getName().substring(0, 1).toUpperCase()
//								+propertyValue.getName().substring(1), value.getClass());
//				declaredMethod.setAccessible(true);
//				declaredMethod.invoke(bean, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**这个方法已经无用
	 * 因为有元数据：那么就有bean的Class实例对象,那么是可以直接newInstance
	 * @see com.earnfish.factory.AbstractBeanFactory#doCreateBean(com.earnfish.BeanDefinition)
	 */
	Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
		return beanDefinition.getBeanClass().newInstance();
	}

}
