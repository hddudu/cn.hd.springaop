package com.earnfish.aop;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import org.aspectj.weaver.tools.ShadowMatch;

/**
 * 通过AspectJ表达式识别切点： 需要切点、 类过滤器、 方法匹配器
 * @author dudu
 *
 */
@SuppressWarnings("rawtypes")
public class AspectJExpressionPointcut implements Pointcut, ClassFilter,
		MethodMatcher {

	//通过解析器解析表达式中的切点
	private PointcutParser pointcutParser;
	
	private String expression;
	
	private PointcutExpression pointcutExpression;
	
	//原始的 默认的 支持的 表达式
	private static final Set<PointcutPrimitive> DEFAULT_SUPPORTED_PRIMITIVES = new HashSet<PointcutPrimitive>();
	
	static {
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.ARGS);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.REFERENCE);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.THIS);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.TARGET);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.WITHIN);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_ANNOTATION);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_WITHIN);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_ARGS);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_TARGET);
	}
	
	//实例化默认支持类型
	public AspectJExpressionPointcut() {
		this(DEFAULT_SUPPORTED_PRIMITIVES);
	}
	
	public AspectJExpressionPointcut(Set<PointcutPrimitive> supportedPrimitives) {
		pointcutParser = PointcutParser
					.getPointcutParserSupportingSpecifiedPrimitivesAndUsingContextClassloaderForResolution(supportedPrimitives);
	}
	
	
	
	/**
	 * 方法类 进行精确匹配
	 */
	public boolean matches(Method method, Class targetClass) {
		checkReadyToMatch();
		//
		ShadowMatch shadowMatch = pointcutExpression.matchesMethodExecution(method);
		if(shadowMatch.alwaysMatches()) {
			return true;
		} else if(shadowMatch.neverMatches()){
			return false;
		}
		//TODO:其他情况不判断了，详情见： org.springframework.aop.aspectj.RuntimeTestWalker
		return false;
	}
	
	/**
	 * 创建切点表达式
	 */
	protected void checkReadyToMatch() {
		if(pointcutExpression == null) {
			pointcutExpression = buildPointcutExpression();
		}
	}
	
	/**
	 * 通过解析表达式获取切点表达式
	 * @return
	 */
	private PointcutExpression buildPointcutExpression() {
		return pointcutParser.parsePointcutExpression(expression);
	}

	/**
	 * 类匹配: 切点表达式中进行 : 加入到切点表达式直接匹配
	 */
	public boolean matches(Class targetClass) {
		checkReadyToMatch();
		return pointcutExpression.couldMatchJoinPointsInType(targetClass);
	}

	public ClassFilter getClassFilter() {
		return this;//其实就是当前对象
	}

	public MethodMatcher getMethodMatcher() {
		return this;//其实就是当前对象
	}
	/**
	 * 设置表达式: 切点解析器不变，放入构造初始化
	 * 		切点表达式和表达式作为变量
	 * 	如果切点表达式为空，那么就需要先进行建立
	 * @param expression
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}

}
