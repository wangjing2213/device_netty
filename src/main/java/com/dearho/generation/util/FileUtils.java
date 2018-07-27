package com.dearho.generation.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dearho.generation.config.MybatisConfig;
import com.dearho.generation.enums.CodeTypeEnum;

import freemarker.template.Template;

public class FileUtils {

	Logger log = LoggerFactory.getLogger(this.getClass());
    /**
     * 根据freemarker模板创建文件
     * @param filePath 文件路径
     * @param dataMap 模板的动态数据
     * @param template freemarker 模板
     * @throws Exception
     */
    public static void writeFile(String filePath, Map<String,Object> dataMap, Template template) throws Exception{
        //获取文件所在的文件夹
        String dir = filePath.substring(0,filePath.lastIndexOf(File.separator));
        File dirFile = new File(dir);
        //检查文件夹，不存在则创建
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        File file = new File(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        template.process(dataMap,bufferedWriter);
        bufferedWriter.close();
    }

    /**
     * 组合文件路径
     * @param config
     * @param codeTypeEnum 生成代码的类型 如：（model、mapper、mapping）
     * @return
     */
    public static String getPath(MybatisConfig config, CodeTypeEnum codeTypeEnum){
        StringBuffer stringBuffer = new StringBuffer(config.getGeneratorPath());
        switch (codeTypeEnum){
            case SERVICE:
                stringBuffer.append(File.separator)
                        .append(config.getServicePackage().replace(".", File.separator))
                        .append(File.separator)
                        .append(config.getDomainObjectName())
                        .append("Service.java");
                break;
            case SERVICEIMPL:
                stringBuffer.append(File.separator)
                        .append(config.getServicePackage().replace(".", File.separator))
                        .append(File.separator)
                        .append("impl")
                        .append(File.separator)
                        .append(config.getDomainObjectName())
                        .append("ServiceImpl.java");
                break;
            case CONTROLLER:
                stringBuffer.append(File.separator)
                        .append(config.getControllerPackage().replace(".",File.separator))
                        .append(File.separator)
                        .append(config.getDomainObjectName())
                        .append("Controller.java");
                break;
            
        }
        return stringBuffer.toString();
    }
}
