package com.datastructure.dataobject.datatransmitobject;

import java.io.Serializable;

import com.sun.xml.internal.txw2.IllegalAnnotationException;

public abstract class DataElement<T extends DataElement>
	implements Serializable	{

	/**
	 * 必要
	 */
	private static final long serialVersionUID = -3129780608874674995L;
	
	private String name;
	private boolean isChange = true;
	public DataElement() {
		
	}
	public DataElement(String name, boolean isChange) {
		super();
		this.name = name;
		this.isChange = isChange;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isChange() {
		return isChange;
	}
	public void setChange(boolean isChange) {
		this.isChange = isChange;
	}
	
	public void check() {
		if(!(isChange())) {
			throw new IllegalAnnotationException("改变");
		}
	}
	
	public abstract T clone();//克隆
	
	public abstract T cloneWithOutData();//克隆
	
	public abstract void copy(T paramT);//复制
	
	public abstract boolean equals(T paramT);//比较相等
	
	public abstract String toString();//转字符串
	
	public abstract String toJSON();//转json串
	
	public abstract String toXML();//转xml
}
