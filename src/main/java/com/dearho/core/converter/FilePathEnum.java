package com.dearho.core.converter;

import com.dearho.core.Constants;
import com.dearho.util.property.ConfigProperties;

public enum FilePathEnum implements IBaseEnum {
		

		COMMON_IMAGE("commonImage","" ),
		COMMON_FILE("commonFile", "");//ConfigProperties.instance().getCommonFilePath());
	    

	    private String name;
	    private String path;

	    FilePathEnum(String name, String path) {
	        this.name = name;
	        this.path = path;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		

	   
}
