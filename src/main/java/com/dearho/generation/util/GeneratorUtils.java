package com.dearho.generation.util;


import java.util.HashMap;
import java.util.Map;

import com.dearho.generation.config.MybatisConfig;
import com.dearho.generation.enums.CodeTypeEnum;

import freemarker.template.Template;

public class GeneratorUtils {

   
    
    
    public static void genCode(MybatisConfig genConfiguration,
            String loadTemplatePath,
            CodeTypeEnum codeTypeEnum){
			Map dataMap = new HashMap();
			dataMap.put("config", genConfiguration);
			
			Template template = FreemarkerUtils.getTemplate(loadTemplatePath);
			String filePath = FileUtils.getPath(genConfiguration, codeTypeEnum);
			try {
			FileUtils.writeFile(filePath, dataMap, template);
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
	}
