package com.dearho.util.baidu;


import java.util.Map;
import java.util.TreeMap;

/**
 * 百度地图地址解析和逆地址解析工具类
 * -用于提供从地址到经纬度坐标或者从经纬度坐标到地址的转换服务
 * Created by LH on 2016-12-05.
 */
public class BaiduGeocodingUtil {

    //输出格式为json或者xml
    public final static  String output_type_json="json";
    public final static  String output_type_xml="xml";

    //URL
    private final static  String geocoder_url="http://api.map.baidu.com/geocoder/v2/";

    /**
     * 地址解析
     * @param address 地址信息 -必填项
     * @param city  城市
     * @param outputType 输出格式 -默认：xml,
     *                   -(json,xml)
     * @return String json
     */
    public static String addressResolution(String address,String city,String outputType){
        Map<String,Object> map = new TreeMap<String,Object>();
        map.put("address",address);
        map.put("city",city);
        map.put("output",outputType);
        String param= SnCalUtil.sncal(map,"/geocoder/v2/");
        return  HttpRequest.sendPost(geocoder_url,param);

    }

    /**
     * 百度逆地址解析
     * @param location 经纬度坐标(lat<纬度>,lng<经度>) -必填项
     * @param coordtype 坐标的类型 -默认：bd09ll 百度经纬度坐标
     *                  -(bd09ll（百度经纬度坐标）、bd09mc（百度米制坐标）、gcj02ll（国测局经纬度坐标）、wgs84ll（ GPS经纬度))
     * @param pois 是否显示指定位置周边的poi -默认：0;
     *             -(0为不显示，1为显示。当值为1时，显示周边100米内的poi)
     * @param outputType 输出格式 -默认：xml,
     *                   -(json,xml)
     * @return String json
     */
    public static String reverseAddressResolution(String location,String coordtype,Integer pois,String outputType){
        Map<String,Object> map = new TreeMap<String,Object>();
        map.put("location",location);
        map.put("coordtype",coordtype);
        map.put("pois",pois);
        map.put("output",outputType);
        String param= SnCalUtil.sncal(map,"/geocoder/v2/");
        return  HttpRequest.sendPost(geocoder_url,param);
    }
}
