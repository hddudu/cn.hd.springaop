package com.datastructure.dataobject.context;

import java.io.Serializable;

/**
 * @author dudu
 *
 * @param <T>
 */
public abstract class Context<T> implements IContext<T>,
		Serializable, Cloneable {
	
	public String logicVersion;
	public String logicCode;
	public String logicPath;
	public String createTime;
	public String monitorId;
	public T dataMap;
	
	public String getLogicCode() {
		return null;
	}

	public void setLogicCode(String paramString) {

	}

	public String getLogicPath() {
		return null;
	}

	public void setLogicPath(String paramPath) {

	}

	public String getCreateTime() {
		return null;
	}

	public void setCreateTime(String paramString) {

	}

	public T getDataMap() {
		return null;
	}

	public void setDataMap(T paramT) {

	}

	public String getMonitorId() {
		return null;
	}

	public void setMonitorId(String paramString) {

	}

}
