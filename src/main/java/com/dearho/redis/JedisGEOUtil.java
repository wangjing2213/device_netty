package com.dearho.redis;

import java.util.List;
import java.util.Map;

import com.dearho.core.Constants;

import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.params.geo.GeoRadiusParam;

/**
 * 使用redisGEO来存储司机位置信息
 * 可以得到某个成员附近的成员，或者某个点附近的成员，计算两点距离，等
 * @author 王靖
 *
 */
public class JedisGEOUtil {

	 private static JedisPool jedisPool = null;  
	    // Redis服务器IP  
	    private static String ADDR = "101.201.114.83";  
	    // Redis的端口号  
	    private static int PORT = 6379;  
	    // 访问密码  
	    private static String AUTH = "sharego";  
	    
	    /** 
	     * 初始化Redis连接池 
	     */  
	    static {  
	        try {  
	            JedisPoolConfig config = new JedisPoolConfig();  
	            // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true  
	            config.setBlockWhenExhausted(true);  
	            // 设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)  
	            config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");  
	            // 是否启用pool的jmx管理功能, 默认true  
	            config.setJmxEnabled(true);  
	            // 最大空闲连接数, 默认8个 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。  
	            config.setMaxIdle(8);  
	            // 最大连接数, 默认8个  
	            config.setMaxTotal(200);  
	            // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；  
	            config.setMaxWaitMillis(1000 * 100);  
	            // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；  
	            config.setTestOnBorrow(true);  
	            jedisPool = new JedisPool(config, ADDR, PORT, 3000, AUTH);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	    /** 
	     * 获取Jedis实例 
	     * 
	     * @return 
	     */  
	    public synchronized static Jedis getJedis() {  
	        try {  
	            if (jedisPool != null) {  
	                Jedis resource = jedisPool.getResource();  
	                return resource;  
	            } else {  
	                return null;  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	    }  
	  
	    /** 
	     * 释放jedis资源 
	     * 
	     * @param jedis 
	     */  
	    public static void close(final Jedis jedis) {  
	        if (jedis != null) {  
	            jedis.close();  
	        }  
	    }  
	  
	    /** 
	     * 增加地理位置的坐标 
	     * @param key 
	     * @param coordinate 
	     * @param memberName 
	     * @return 
	     */  
	    public static Long geoadd(String key, GeoCoordinate coordinate, String memberName) {  
	        Jedis jedis = null;  
	        try {  
	            jedis = jedisPool.getResource();  
	            return jedis.geoadd(key,coordinate.getLongitude(),coordinate.getLatitude(),memberName);  
	        } catch (Exception e) {  
	            System.out.println(e.getMessage());  
	        } finally {  
	            if (null != jedis)  
	                jedis.close();  
	        }  
	        return null;  
	    }  
	  
	    /** 
	     * 批量添加地理位置 
	     * @param key 
	     * @param memberCoordinateMap 
	     * @return 
	     */  
	    public static Long geoadd(String key, Map<String, GeoCoordinate> memberCoordinateMap){  
	        Jedis jedis = null;  
	        try {  
	            jedis = jedisPool.getResource();  
	            return jedis.geoadd(key, memberCoordinateMap);  
	        } catch (Exception e) {  
	            System.out.println(e.getMessage());  
	        } finally {  
	            if (null != jedis)  
	                jedis.close();  
	        }  
	        return null;  
	    }  
	  
	    
	  
	    
	    
	    /** 
	     * 根据给定地理位置坐标获取指定范围内的地理位置集合（返回匹配位置的经纬度 + 匹配位置与给定地理位置的距离 + 从近到远排序，） 
	     * @param key 
	     * @param coordinate 
	     * @param radius 
	     * @return  List<GeoRadiusResponse> 
	     */  
	    public static List<GeoRadiusResponse> geoRadius(String key, GeoCoordinate coordinate, double radius) {  
	        Jedis jedis = null;  
	        try {  
	            jedis = jedisPool.getResource();  
	            return jedis.georadius(key, coordinate.getLongitude(), coordinate.getLatitude(), radius, GeoUnit.KM, GeoRadiusParam.geoRadiusParam().withDist().withCoord().sortAscending());  
	        } catch (Exception e) {  
	            System.out.println(e.getMessage());  
	        } finally {  
	            if (null != jedis)  
	                jedis.close();  
	        }  
	        return null;  
	    }  
	  
	    
	    /** 
	     * 根据给定地理位置获取指定范围内的地理位置集合（返回匹配位置的经纬度 + 匹配位置与给定地理位置的距离 + 从近到远排序，） 
	     * @param key 
	     * @param member 
	     * @param radius 
	     * @return  List<GeoRadiusResponse> 
	     */  
	    public static List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius){  
	        Jedis jedis = null;  
	        try {  
	            jedis = jedisPool.getResource();  
	            return jedis.georadiusByMember(key, member, radius, GeoUnit.KM, GeoRadiusParam.geoRadiusParam().withDist().withCoord().sortAscending());  
	        } catch (Exception e) {  
	            System.out.println(e.getMessage());  
	        } finally {  
	            if (null != jedis)  
	                jedis.close();  
	        }  
	        return null;  
	    }  
	  
	  
	    
	    /** 
	     * 查询两位置距离 
	     * @param key 
	     * @param member1 
	     * @param member2 
	     * @param unit 
	     * @return 
	     */  
	    public static Double geoDist(String key, String member1, String member2, GeoUnit unit){  
	        Jedis jedis = null;  
	        try {  
	            jedis = jedisPool.getResource();  
	            return jedis.geodist(key, member1, member2, unit);  
	        } catch (Exception e) {  
	            System.out.println(e.getMessage());  
	        } finally {  
	            if (null != jedis)  
	                jedis.close();  
	        }  
	        return null;  
	    }  
	  
	    /** 
	     * 可以获取某个地理位置的geohash值 
	     * @param key 
	     * @param members 
	     * @return 
	     */  
	    public static List<String> geohash(String key, String... members){  
	        Jedis jedis = null;  
	        try {  
	            jedis = jedisPool.getResource();  
	            return jedis.geohash(key, members);  
	        } catch (Exception e) {  
	            System.out.println(e.getMessage());  
	        } finally {  
	            if (null != jedis)  
	                jedis.close();  
	        }  
	        return null;  
	    }  
	  
	    /** 
	     * 获取地理位置的坐标 
	     * @param key 
	     * @param members 
	     * @return 
	     */  
	    public static List<GeoCoordinate> geopos(String key, String... members){  
	        Jedis jedis = null;  
	        try {  
	            jedis = jedisPool.getResource();  
	            return jedis.geopos(key, members);  
	        } catch (Exception e) {  
	            System.out.println(e.getMessage());  
	        } finally {  
	            if (null != jedis)  
	                jedis.close();  
	        }  
	        return null;  
	    }  
	   
	    
	    public static void main(String[] args) {
	    	//116.521596,39.793977  wx4f7s22tyzr

	    	double longitude = Double.valueOf("116.521585");
	    	double latitude = Double.valueOf("39.793975");
	    	GeoCoordinate coordinate = new GeoCoordinate(longitude, latitude);
	    	Long l = JedisGEOUtil.geoadd("dearho_beijing_test", coordinate, "王靖1");
	    	System.out.println(l);
//	    	longitude = Double.valueOf("116.521586");
//	    	latitude = Double.valueOf("39.793976");
//	    	coordinate = new GeoCoordinate(longitude, latitude);
//	    	JedisGEOUtil.geoadd("dearho_beijing_test", coordinate, "王靖2");
//	    	
//	    	longitude = Double.valueOf("116.391171");
//	    	latitude = Double.valueOf("39.931369");
//	    	coordinate = new GeoCoordinate(longitude, latitude);
//	    	JedisGEOUtil.geoadd("dearho_beijing_test", coordinate, "高瑶");
//	    	
//	    	longitude = Double.valueOf("116.517904");
//	    	latitude = Double.valueOf("39.797858");
//	    	coordinate = new GeoCoordinate(longitude, latitude);
//	    	JedisGEOUtil.geoadd("dearho_beijing_test", coordinate, "黄金伟");
//	    	
//	    	longitude = Double.valueOf("116.521462");
//	    	latitude = Double.valueOf("39.796666");
//	    	coordinate = new GeoCoordinate(longitude, latitude);
//	    	JedisGEOUtil.geoadd("dearho_beijing_test", coordinate, "魏仙锋");
//	    	
//	    	longitude = Double.valueOf("116.51697");
//	    	latitude = Double.valueOf("39.796389");
//	    	coordinate = new GeoCoordinate(longitude, latitude);
//	    	JedisGEOUtil.geoadd("dearho_beijing_test", coordinate, "王涛");
	    	
	    	
	    	//获得一个key下，某一个成员的位置 GEOhash值
	    	List<String> hash= JedisGEOUtil.geohash(Constants.driver_geopos_key,"王靖1","王靖2","高瑶","黄金伟","魏仙锋","王涛");
	    	System.out.println(hash);
	    	
	    	//获得一个key下，某一个成员的位置 坐标
	    	List<GeoCoordinate> hash1= JedisGEOUtil.geopos(Constants.driver_geopos_key,"王靖1","王靖2","高瑶","黄金伟","魏仙锋","王涛");
	    	System.out.println(hash1);
	    	
//	    	//查询两点距离
//	    	Double distance =  JedisGEOUtil.geoDist("dearho_beijing_test","王靖1","高瑶",GeoUnit.KM);
//	    	System.out.println(distance);
//	    	
//	    	
////	    	//获取某个人附近 1KM半径内的点
//	    	List<GeoRadiusResponse> responses = JedisGEOUtil.georadiusByMember("dearho_beijing_test","王靖1",1);
//	    	for(int i=0; i<responses.size(); i++){
//	    		System.out.println(responses.get(i).getMemberByString()+"，距离："+responses.get(i).getDistance()+"KM，"+"坐标是"+responses.get(i).getCoordinate());//member名称
//	    	}
//	    	System.out.println("-------------------------------");
//	    	
////	    	//获取某坐标附近 1KM半径内的点
//	    	coordinate = new GeoCoordinate(Double.valueOf("116.521596"), Double.valueOf("39.793977"));
//	    	List<GeoRadiusResponse> responses1 = JedisGEOUtil.geoRadius("dearho_beijing",coordinate,1);
//	    	for(int i=0; i<responses1.size(); i++){
//	    		System.out.println(responses1.get(i).getMemberByString()+"，距离："+responses1.get(i).getDistance()+"KM，"+"坐标是"+responses1.get(i).getCoordinate());//member名称
//	    	}
		}
	    
}
