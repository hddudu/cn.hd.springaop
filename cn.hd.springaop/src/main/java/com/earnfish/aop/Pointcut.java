package com.earnfish.aop;

/**
 * 切点： 确定是对什么类的什么方法进行aop（面向切面编程）（就是确定在哪里切）
 * 	包含了 ： 类过滤器 + 方法匹配器 ==》 准确地找到了将要被切入的方法
 * 	完成了 切点接口之后，接下来就是进行切点的切入了==>这个是通过表达式的方式进行切入
 * @author dudu
 * 
 * Spring中关于Pointcut包含两个角色：ClassFilter和MethodMatcher，分别是对类和方法做匹配。
 * Pointcut有很多种定义方法，
 * 例如类名匹配、正则匹配等，但是应用比较广泛的应该是和AspectJ表达式的方式。
 *
 */
public interface Pointcut {
	
	/**
	 * 获取ClassFilter 对象
	 * 类名匹配（用于 筛选要代理的目标兑现）
	 * @return
	 */
	ClassFilter getClassFilter();
	
	/**
	 * 获取一个 MethodMatcher 对象
	 * 方法名匹配
	 * @return
	 */
	MethodMatcher getMethodMatcher();
}
