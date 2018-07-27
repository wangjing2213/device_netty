package com.dearho.result;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.dearho.util.DateJsonValueProcessor;


public class JSONResult implements java.io.Serializable {
	
	public final static int APP_RESULT_CODE_SUCCESS = 0;
	public final static int APP_RESULT_CODE_FAIL = 1;
	public final static int APP_RESULT_CODE_LOGIN = -1;
	public final static int APP_RESULT_CODE_FAIL_VALIDATE = -2;

	
	
	
    /**
     * 响应代码
     */
    private int resultCode;
    /**
     * 响应消息
     */
    private String resultMsg;

    /**
     * 响应结果
     */
    private Object resultValue;
    
    

    public JSONResult(int resultCode, String resultMsg) {
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}
    
    

	public JSONResult(int resultCode, String resultMsg, Object resultValue) {
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.resultValue = resultValue;
	}



	public static JSONResult AppJSONResult(int code,String message) {
		JSONResult result=new JSONResult(code,message);
		return result;
    }
	public static JSONResult AppJSONResult(int code,Object resultValue) {
		JSONResult result=new JSONResult(code,"",resultValue);
		return result;
    }
	public static String AppJSONStringResult(int code,String message) {
		JSONResult result=new JSONResult(code,message);
		return result.toString();
    }
	 /**
     * 正确返回
     * @param resultCode
     * @param resultValue
     * @return
     */
    public static String AppJsonResult(int resultCode,Object resultValue) {
    	String valueStr = toJsonFromObject(resultValue);
//    	DESEncryptHelper desHelper = new DESEncryptHelper(Constants.APP_DES_KEY);
    	/*try {
//			valueStr = desHelper.getEncryptStr(valueStr);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
    	return new JSONObject().element("resultCode", resultCode).element("resultValue", valueStr).toString();
    }
    public static String toJsonFromObject(Object obj){
  	  JsonConfig jf = new JsonConfig();  
        jf.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor());
  	  JSONArray json = JSONArray.fromObject(obj,jf);
  	  
  	  return json.toString();
    }
    
	public static JSONResult AppJSONResult(int code,String message,Object val) {
		JSONResult result=new JSONResult(code,message,val);
		return result;
    }
	
	
	public static JSONResult AppSuccessJSONResult(String message) {
		JSONResult result=new JSONResult(APP_RESULT_CODE_SUCCESS,message);
		return result;
    }
	public static JSONResult AppSuccessJSONResult(String message,Object val) {
		JSONResult result=new JSONResult(APP_RESULT_CODE_SUCCESS,message,val);
		return result;
    }
	public static JSONResult AppSuccessJSONResult(Object val) {
		JSONResult result=new JSONResult(APP_RESULT_CODE_SUCCESS,"",val);
		return result;
    }
	
	public static JSONResult AppFailJSONResult(String message) {
		JSONResult result=new JSONResult(APP_RESULT_CODE_FAIL,message);
		return result;
    }
	public static JSONResult AppFailJSONResult(String message,Object val) {
		JSONResult result=new JSONResult(APP_RESULT_CODE_FAIL,message,val);
		return result;
    }
	public static JSONResult AppValidateJSONResult(String message) {
		JSONResult result=new JSONResult(APP_RESULT_CODE_FAIL,message);
		return result;
    }
	
	public static JSONResult AppValidateJSONResult(BindingResult errors) {
		if(errors!=null && errors.hasErrors()){
			String firstMessage=null;
			Map<String,String> errorMap=new LinkedHashMap<String,String>();
			List<ObjectError> errorList = errors.getAllErrors();
	        for(int i=0;i<errorList.size();i++){
	        	
	        	ObjectError error =errorList.get(i);
	        	if(error instanceof FieldError){
	        		FieldError fieldError=(FieldError)error;
	        		errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		        	
	        	}else{
	        		errorMap.put(i+"", error.getDefaultMessage());
	        	}
	        	if(i==0){
	        		firstMessage=error.getDefaultMessage();
	        	}
	        	
	        }
	        JSONResult result=new JSONResult(APP_RESULT_CODE_FAIL_VALIDATE,firstMessage,errorMap);
			return result;
		}else{
			JSONResult result=new JSONResult(APP_RESULT_CODE_FAIL,"校验失败");
			return result;
		}
		
		
    }
	
	



	public int getResultCode() {
		return resultCode;
	}



	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}



	public String getResultMsg() {
		return resultMsg;
	}



	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}



	public Object getResultValue() {
		return resultValue;
	}



	public void setResultValue(Object resultValue) {
		this.resultValue = resultValue;
	}



	@Override
	public String toString() {
		return "{\"resultCode\":" + resultCode + ", \"resultMsg\":" + resultMsg + ", \"resultValue\":" + resultValue
				+ "}";
	}

    
	
	
}
