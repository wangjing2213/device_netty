package com.dearho.generation.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;

/**
 * 加载freemarker模板
 * @author liusong
 */
public class FreemarkerUtils {

    /**
     * 加载 freemarker模板
     * @param ftlPath
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    public static Template getTemplate(String ftlPath){
        //1.创建配置实例Cofiguration
        Template template = null;
        Configuration cfg = new Configuration();
        try {
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            template = cfg.getTemplate(ftlPath);
        } catch (IOException e) {
            System.out.println("加载freemarker模板失败，请检查ftl目录-----》》");
            e.printStackTrace();
        }
        return template;
    }
}
