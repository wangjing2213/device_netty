package com.dearho.util.hawkeye.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.dearho.util.hawkeye.HawKeyeUrl;

/**
 *
 * @ClassName:  QueryDistance   
 * @Description:TODO(getdistance——查询轨迹里程)   
 * @author: wangtao 
 * @date:   2018年7月2日 下午3:20:12     
 *   
 */
public class QueryDistance {
	private static Logger log = Logger.getLogger(QueryTrack.class);
    private static String formats = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) throws Exception {
    	String start = "2018-06-11 10:10:10";
    	String end = "2018-06-11 20:20:20";
    	SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date st = time.parse(start);
    	Date et = time.parse(end);
    	Integer distance = queryDistance("jinwei", st, et);
    	System.out.println(distance);
    	
    	Integer kmDistance = queryKmDistance("jinwei", st, et);
    	System.out.println(kmDistance);
    	
    	//{"distance":8777.6320348798,"message":"成功","status":0}	    不使用纠偏距离
    	//{"distance":8977.7370385113,"message":"成功","status":0}	    使用纠偏距离  
	}

    
    public static Integer queryKmDistance(String entityName, Date startDate,Date endDate){
    	Integer distance = queryDistance(entityName, startDate, endDate);
    	Integer kmDistance=null;
    	if(distance!=null){
    		return (new BigDecimal(distance)).divide(new BigDecimal(1000),0,RoundingMode.HALF_UP).intValue();
    	}
    	return kmDistance;
    }

    /**
     * 
     * @param entityName
     * @param startDate
     * @param endDate
     * @return 距离 (米)
     */
    public static Integer queryDistance(String entityName, Date startDate,Date endDate){
    	//http://lbsyun.baidu.com/index.php?title=yingyan/api/v3/trackprocess    参数明细参考
        Map<String, String> map = new HashMap<String,String>();
        map.put("ak", HawKeyeUrl.AK);
        map.put("service_id",HawKeyeUrl.SERVER_ID);
        map.put("entity_name",entityName);
        map.put("start_time",startDate.getTime()/1000+"");
        map.put("end_time",endDate.getTime()/1000+"");
        map.put("is_processed","1");
        map.put("process_option","need_denoise =1,need_vacuate=1,need_mapmatch=0,radius_threshold=0,transport_mode=driving");
        //里程补偿方式     no_supplement：不补充，中断两点间距离不记入里程。straight：使用直线距离补充
        //driving：使用最短驾车路线距离补充riding：使用最短骑行路线距离补充walking：使用最短步行路线距离补充
        map.put("supplement_mode","driving");
        String post = HttpclientUtil.get(HawKeyeUrl.query_distance, map,"utf-8","");
       // log.info(post);
        if(post!=null&&!"".equals(post)){
            JSONObject json = JSONObject.parseObject(post);
            log.info(json);
            int status = json.getInteger("status");
            if(status==0){
                Double distance = null;
                //开始解析
                distance = json.getDouble("distance");
                return  distance.intValue();
            }else {
                log.info(json.getString("message"));
            }
        }

        return null;
    }


	
}
