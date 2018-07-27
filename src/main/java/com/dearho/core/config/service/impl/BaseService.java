
package com.dearho.core.config.service.impl;


import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dearho.core.config.service.IService;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;


public abstract class BaseService<T> implements IService<T> {

    @Autowired
    protected Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public int save(T entity) {
        return mapper.insert(entity);
    }

    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }
    
    public int deleteByExampleId(List<String> idsList) {
    	Class <T > c=null;
		try {
			 c =  (Class < T > ) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[ 0 ];
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	 Example example = new Example(c);
         Example.Criteria criteria = example.createCriteria();
       
         criteria.andIn("id", idsList);
         return mapper.deleteByExample(example);
        
    }
    
    public int deleteByIntegerExampleId(List<Integer> idsList) {
    	Class <T > c=null;
		try {
			 c =  (Class < T > ) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[ 0 ];
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	 Example example = new Example(c);
         Example.Criteria criteria = example.createCriteria();
       
         criteria.andIn("id", idsList);
         return mapper.deleteByExample(example);
        
    }

    public Map<String,T> selectAllToMap(){
    	List<T> list=mapper.selectAll();
    	Map<String, T> map=new HashMap<String,T>();
    	Class <T > claz=null;
		try {
			claz =  (Class < T > ) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[ 0 ];
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		 Field fieldnum=null;
		try {
			fieldnum = claz.getDeclaredField("id");
			if(fieldnum!=null){
				 fieldnum.setAccessible(true);
				 if(list!=null && !list.isEmpty()){
			    		for(int i=0;i<list.size();i++){
			    			map.put( fieldnum.get(list.get(i)).toString(), list.get(i));
			    		}
			    	}
			}
		} catch (Exception e) {
	
			e.printStackTrace();
		}
        
    	return map;
    }
    //TODO 其他...
    
    
}
