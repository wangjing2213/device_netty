package com.dearho.util;

import java.util.Calendar;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * 格式化json中date
 * @author liusong
 *
 */
public class DateJsonValueProcessor implements JsonValueProcessor {

	
    public DateJsonValueProcessor(){  
    }  
      
    public Object processArrayValue(Object value, JsonConfig jsonConfig)  
    {  
        return null;  
    }  
  
    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig)  
    {  
        if(value == null)  
        {  
            return null;  
        }  
       
        if (value instanceof java.util.Date){
        	Calendar calendar = Calendar.getInstance();
        	calendar.setTime((java.util.Date) value);
        	
        	JSONObject sParaTemp = new JSONObject();  
          
    		sParaTemp.put("day", calendar.get(Calendar.DATE));
            sParaTemp.put("hours", calendar.get(Calendar.HOUR_OF_DAY));
            sParaTemp.put("minutes", calendar.get(Calendar.MINUTE));
            sParaTemp.put("month", calendar.get(Calendar.MONTH)+1);
            sParaTemp.put("seconds", calendar.get(Calendar.SECOND));
            sParaTemp.put("time", calendar.getTime().getTime());
            sParaTemp.put("year",calendar.get(Calendar.YEAR));
            return sParaTemp;
           
        }  
          
        return value.toString();  
    }  
    
    public static void main(String[] args) {
    	Calendar calendar = Calendar.getInstance();
    
    	calendar.getTime();
    	
    	
    	
    	
	}

}
