package com.earnfish.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.earnfish.BeanDefinition;
import com.earnfish.BeanReference;
import com.earnfish.PropertyValue;
import com.earnfish.io.ResourceLoader;

/**
 * 从XML文件中读取了bean的定义，具体实现了loadBeanDefinitions方法
 * 在loadBeanDefinitions 并没有实例化bean，只是注册了bean的定义
 * @author dudu
 *
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
	
	/**
	 * 继承父类的构造器完成初始化类加载器的初始化
	 * @param resourceLoader
	 */
	public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
		super(resourceLoader);
	}

	/**加载并通过bean定义注册bean
	 * @see com.earnfish.BeanDefinitionReader#loadBeanDefinitions(java.lang.String)
	 */
	public void loadBeanDefinitions(String location) throws Exception {
		//获取资源输入流: 通过资源类加载器类进行加载
		InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
		/**
		 * 从xml文件中读取所有bean的定义，并注册到registry中
		 * 注意： 此时bean定义里并没有实例化该bean
		 */
		doLoadBeanDefinitions(inputStream);
	}

	protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
		//获取工厂: 自带解析xml文件
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获取生成器
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		//解析为Document：
		Document document = docBuilder.parse(inputStream);
		//解析并注册其中的bean
		registerBeanDefinitions(document);
		inputStream.close();
	}

	/**
	 * @param document
	 * @throws Exception
	 */
	protected void registerBeanDefinitions(Document document) throws Exception {
		//获取根标签<beans>
		Element root = document.getDocumentElement();
		parseBeanDefinitions(root);
	}

	protected void parseBeanDefinitions(Element root) {
		//获取所有<beans>下的<bean>
		NodeList nodeList = root.getChildNodes();
		for(int i = 0; i < nodeList.getLength(); i++ ) {
			Node node = nodeList.item(i);
			//如果孩子标签是Element
			if(node instanceof Element) {
				Element ele = (Element) node;
				//解析bean标签
				processBeanDefinition(ele);
			}
		}
	}

	/**
	 * 处理解析bean标签
	 * @param ele
	 */
	protected void processBeanDefinition(Element ele) {
		//获取bean标签的id属性作为bean的name
		String name = ele.getAttribute("id");
		//获取bean标签的class属性作为bean的classname
		String className = ele.getAttribute("class");
		BeanDefinition beanDefinition = new BeanDefinition();
		//解析bean标签下的property子标签
		processProperty(ele, beanDefinition);
		
		//设置classname的同时，也在内部设置了class
//		System.out.println(className);
		beanDefinition.setBeanClassName(className);
		
		//注册类定义:{outputService=com.earnfish.BeanDefinition@66048bfd}
		getRegistry().put(name, beanDefinition);
//		System.out.println(getRegistry());
		//{outputService=com.earnfish.BeanDefinition@7f31245a, helloService=com.earnfish.BeanDefinition@6d6f6e28}
	}

	/**
	 * 解析bean标签的property子标签
	 * @param ele
	 * @param beanDefinition
	 */
	protected void processProperty(Element ele, BeanDefinition beanDefinition) {
		//获取property标签
		NodeList propertyNodes = ele.getElementsByTagName("property");
		for(int i = 0; i < propertyNodes.getLength(); i++ ) {
			Node node = propertyNodes.item(i);
			if(node instanceof Element) {
				Element propertyEle = (Element) node;
				String name = propertyEle.getAttribute("name");
				String value = propertyEle.getAttribute("value");
				//如果是value型的属性值
				if(value != null && value.length() > 0) {
//					System.out.println(name + "......" + value);
//					System.out.println(beanDefinition);
//					System.out.println(beanDefinition.getPropertyValues());//null
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
				} else {
					//否则是ref型的属性值
					String ref = propertyEle.getAttribute("ref");
					if(ref == null || ref.length() == 0) {
						throw new IllegalArgumentException("Configuration problem : <property> element for property '"
								+ name + "' must specify a ref or value");
					}
					BeanReference beanReference = new BeanReference(ref);
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
				}
			}
		}
	}

}
