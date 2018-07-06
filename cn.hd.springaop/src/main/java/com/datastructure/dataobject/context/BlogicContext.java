package com.datastructure.dataobject.context;

import java.util.HashMap;
import java.util.Map;

import com.datastructure.dataobject.datatransmitobject.DataMap;

/**
 * @author dudu
 *
 */
public class BlogicContext extends Context<DataMap> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3907043260199290707L;
	
	public transient Map<String, Object> tempMap = new HashMap<String, Object>();
	private String lastExceLogic;
	
	public Object getTemp(String key) {
		return this.tempMap.get(key);
	}
	
	public void setTemp(String key, Object object) {
		this.tempMap.put(key, object);
	}
	
	public void removeTemp(String key) {
		this.tempMap.remove(key);
	}
	
	public Map<String, Object> getTempMap() {
		return this.tempMap;
	}
	
	public void setTempMap(Map<String, Object> tempMap) {
		this.tempMap = tempMap;
	}
	
	public String getLastExceLogic() {
		return this.lastExceLogic;
	}
	
	public void setLastExceLogic(String lastExceLogic) {
		this.lastExceLogic = lastExceLogic;
	}
	
	public Object clone() throws CloneNotSupportedException {
		BlogicContext cloneBlogicContext = (BlogicContext) super.clone();
		if(cloneBlogicContext.getTempMap() == null) {
			cloneBlogicContext.setTempMap(new HashMap<String, Object>());
		}
		return cloneBlogicContext;
	}
	
}
