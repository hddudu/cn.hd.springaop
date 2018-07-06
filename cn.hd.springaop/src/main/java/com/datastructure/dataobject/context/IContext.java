package com.datastructure.dataobject.context;

/**
 * 上下文接口
 * @author dudu
 *
 */
public abstract interface IContext<T> {
	
	public abstract String getLogicCode();
	
	public abstract void setLogicCode(String paramString);
	
	public abstract String getLogicPath();
	
	public abstract void setLogicPath(String paramPath);
	
	public abstract String getCreateTime();
	
	public abstract void setCreateTime(String paramString);
	
	public abstract T getDataMap();
	
	public abstract void setDataMap(T paramT);
	
	public abstract String getMonitorId();
	
	public abstract void setMonitorId(String paramString);
}
