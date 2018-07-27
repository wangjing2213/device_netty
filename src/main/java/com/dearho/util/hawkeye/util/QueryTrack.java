package com.dearho.util.hawkeye.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dearho.util.hawkeye.HawKeyeUrl;

/**
 * Created by acer on 2017/7/12 0012.
 */
public class QueryTrack {
    private static Logger log = Logger.getLogger(QueryTrack.class);
    private static String formats = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) throws Exception {
    	String start = "2018-06-11 10:10:10";
    	String end = "2018-06-11 20:20:20";
    	SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date st = time.parse(start);
    	Date et = time.parse(end);
    	List<Object[]> list = queryTrackList("jinwei", st, et);
//    	System.out.println(new String("MCODE鍙傛暟涓嶅瓨鍦紝mobile绫诲瀷mcode鍙傛暟蹇呴渶".getBytes("iso-8859-1"),"UTF-8"));
	}


    public static List<Object[]> queryTrackList(String entityName, Date startDate,Date endDate){
    	//http://lbsyun.baidu.com/index.php?title=yingyan/api/v3/trackprocess    参数明细参考
        Map<String, String> map = new HashMap<String,String>();
        map.put("ak", HawKeyeUrl.AK);
        map.put("service_id",HawKeyeUrl.SERVER_ID);
        map.put("entity_name",entityName);
        map.put("start_time",startDate.getTime()/1000+"");
        map.put("end_time",endDate.getTime()/1000+"");
        map.put("is_processed","1");
        map.put("process_option","" +
                "need_denoise =1," +
                "need_vacuate=1," +
                "need_mapmatch=0," +
                "radius_threshold=0," +
                "transport_mode=driving");
        //里程补偿方式     no_supplement：不补充，中断两点间距离不记入里程。straight：使用直线距离补充
        //driving：使用最短驾车路线距离补充riding：使用最短骑行路线距离补充walking：使用最短步行路线距离补充
        map.put("supplement_mode","driving");
        map.put("coord_type_output","bd09ll");//返回坐标类型   gcj02：国测局加密坐标       bd09ll：百度经纬度坐标
        map.put("sort_type","asc");
        map.put("page_index",1+"");
        map.put("page_size","5000");
        String post = HttpclientUtil.get(HawKeyeUrl.query_track, map,"utf-8","");
       // log.info(post);
        if(post!=null&&!"".equals(post)){
            JSONObject json = JSONObject.parseObject(post);
            log.info(json);
            int status = json.getInteger("status");
            if(status==0){
                List<Object[]> list=new ArrayList<Object[]>();
                //开始解析
                JSONObject start_point = json.getJSONObject("start_point");
                JSONObject end_point = json.getJSONObject("end_point");
                JSONArray points = json.getJSONArray("points");
                //a.lng,a.lat,a.offset_lng,a.offset_lat,date_format(a.create_date,'%Y-%m-%d %H:%i:%s')
            //    list.add(getSEPoint(start_point));
                Iterator<Object> iterator = points.iterator();
                while (iterator.hasNext()){
                    JSONObject next = (JSONObject) iterator.next();
                    list.add(getPoint(next));
                }


              //  list.add(getSEPoint(end_point));



                return list;
            }else {
                log.info(json.getString("message"));
            }
        }

        return null;
    }

    private static Object[] getPoint(JSONObject s){

        String longitude = s.getString("longitude");
        String latitude = s.getString("latitude");

        String loc_time = s.getString("loc_time");

        String offset_lat = s.getString("offset_lat");
        String offset_lng = s.getString("offset_lng");



        Long timestamp = Long.parseLong(loc_time) * 1000;
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        Object[]  ss=new Object[5];
        ss[0]=longitude;
        ss[1]=latitude;
        ss[2]=offset_lng==null?longitude:offset_lng;
        ss[3]=offset_lat==null?latitude:offset_lat;
        ss[4]=date;


        return  ss;
    }

    private static Object[] getSEPoint(JSONObject s){

        String longitude = s.getString("longitude");
        String latitude = s.getString("latitude");

        String loc_time = s.getString("loc_time");
        Long timestamp = Long.parseLong(loc_time) * 1000;
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        Object[]  ss=new Object[5];
        ss[0]=longitude;
        ss[1]=latitude;
        ss[2]=longitude;
        ss[3]=latitude;
        ss[4]=date;


        return  ss;
    }
}
