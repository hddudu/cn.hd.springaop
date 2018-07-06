package com.earnfish.aop;

import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;

import com.earnfish.BeanPostProcessor;
import com.earnfish.factory.AbstractBeanFactory;
import com.earnfish.factory.BeanFactory;

/**
 *  实现了BeanFactoryAware接口： 实现了 对 BeanFactory的感知，这样，尽管它是一个容器中的一个bean，
 *  却可以获得容器中一个引用，进而获取容器中的所有的
 *  	切点对象==》bean==》类==》经过类过滤+方法匹配==》只剩下方法
 * 	决定了对哪些对象方法进行代理。解决了为哪些对象提供 AOP的 植入 的问题
 * @author dudu
 *
 */
@SuppressWarnings("unchecked")
public class AspectJAwareAdvisorAutoProxyCreator implements BeanFactoryAware,
		BeanPostProcessor {

	private AbstractBeanFactory beanFactory;

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws Exception {
		return bean;
	}
	
	/**
	 * 可以取看看AbstractBeanFactory的getBean()的实现
	 * bean实例化后要进行初始化操作，会经过这个方法满足条件则生成相关的代理类并返回
	 * 
	 * 总结一句： 类拦截 和 方法匹配 + 原对象都封装在AdvisedSupport里面，
	 * 				类拦截就具体到了通知==》前置、后置 
	 * 					方法匹配 ==》 确定了切点，具体的方法	
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws Exception {
		//如果是切点通知器，则直接返回
		if(bean instanceof AspectJExpressionPointcutAdvisor) {
			return bean;
		}
		//如果是方法拦截器，直接返回
		if(bean instanceof MethodInterceptor) {
			return bean;
		}
		// 通过getBeansForType方法加载BeanFactory 中所有的 PointcutAdvisor（保证了 PointcutAdvisor 的实例化顺序优于普通 Bean。)
		// AspectJ方式实现织入,这里它会扫描所有Pointcut，并对bean做织入。
		List<AspectJExpressionPointcutAdvisor> advisors = beanFactory
					.getBeansForType(AspectJExpressionPointcutAdvisor.class);
		for(AspectJExpressionPointcutAdvisor advisor : advisors) {
			//匹配要拦截的类
			//使用matches匹配器
			if(advisor.getPointcut().getClassFilter().matches(bean.getClass())) {
				//如果匹配了，那么就是要切入的对象类
				// ProxyFactory继承了AdvisedSupport，所以内部封装了TargetSource和MethodInterceptor的元数据对象
				ProxyFactory advisedSupport = new ProxyFactory();
				//设置切点前的方法拦截器 : 其实就是设置通知类型
				advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
				// 设置切点的方法匹配器
				// 利用AspectJ表达式进行方法匹配
				// AspectJExpressionPointcutAdvisor里的AspectJExpressionPointcut的getMethodMatcher()方法
				advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
				//是要拦截的类, 生成一个 TargetSource（要拦截的对象和其类型）(被代理对象)
				TargetSource targetSource = new TargetSource(bean, bean.getClass(), bean.getClass().getInterfaces());
				advisedSupport.setTargetSource(targetSource);
				//交给实现了 AopProxy接口的getProxy方法的ProxyFactory去生成代理对象
				return advisedSupport.getProxy();
			}
		}
		return bean;
	}

	public void setBeanFactory(BeanFactory beanFactory) throws Exception {
		this.beanFactory = (AbstractBeanFactory) beanFactory;
	}
	

}
