package com.dearho.util;


import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by wangtao on 2018/6/6.
 */
public class PhotoUtil {

    /**
     *
     * 功能描述   保存图片
     *
     * @param filedata
     *           文件数据
     *　　返回图片位置
     */
    public static String saveFile( MultipartFile filedata, HttpServletRequest request) {
        // TODO Auto-generated method stub
        String pathval = request.getSession().getServletContext().getRealPath("/")+"WEB-INF/";
        // 根据配置文件获取服务器图片存放路径
        String newFileName = String.valueOf( System.currentTimeMillis());
        String saveFilePath = "images/uploadFile";
        /* 构建文件目录 */
        File fileDir = new File(pathval + saveFilePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        //上传的文件名
        String filename=filedata.getOriginalFilename();
        //文件的扩张名
        String extensionName = filename.substring(filename.lastIndexOf(".") + 1);
        try {
            String imgPath = saveFilePath + newFileName + "." +extensionName;
            //System.out.println(pathval + imgPath);打印图片位置
            FileOutputStream out = new FileOutputStream(pathval + imgPath);
            // 写入文件
            out.write(filedata.getBytes());
            out.flush();
            out.close();
            return imgPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     *
     * 功能描述：删除图片
     *
     * @param oldPic
     *
     */
    private void deleteFile(String oldPic) {
        // TODO Auto-generated method stub

        /* 构建文件目录 */
        File fileDir = new File(oldPic);
        if (fileDir.exists()) {
            //把修改之前的图片删除 以免太多没用的图片占据空间
            fileDir.delete();
        }

    }
    
    public static String uploadPic(File upload,String uploadFileName,String uploadContentType,Integer fileMaxSize,String uploadPath) throws Exception{
		
		
	 	if(upload==null || uploadContentType==null || uploadFileName==null){  
	 		throw new Exception("上传文件为空!");
        }  
	 	
	 	if(uploadFileName.toLowerCase().endsWith("jpg")||uploadFileName.toLowerCase().endsWith("bmp")||uploadFileName.toLowerCase().endsWith("png")||uploadFileName.toLowerCase().endsWith("jpeg")){
	 		
	 	}else{
	 		System.out.println("uploadFileName="+uploadFileName);
	 		throw new Exception("文件格式不正确!");
	 	}

        if(upload.length() > fileMaxSize){ 
        	throw new Exception("文件大小不得大于"+fileMaxSize/1024+"M!");
        }  
		
      //将文件保存到项目目录下   
        String fileName = java.util.UUID.randomUUID().toString();  //采用UUID的方式随机命名
        fileName += uploadFileName.substring(uploadFileName.lastIndexOf("."));  ;  
	   InputStream is = new FileInputStream(upload);  
	      //设置保存目录  
	   judeDirExists(new File(uploadPath));//判断目录是否存在
	   File toFile = new File(uploadPath, fileName);  
	   OutputStream os = new FileOutputStream(toFile);     
	   byte[] buffer = new byte[1024];     
	   int length = 0;  
	   while ((length = is.read(buffer)) > 0) {     
	       os.write(buffer, 0, length);     
	   }     
	   is.close();  
	   os.close(); 
       return fileName;
	}
    
	 private  static void judeDirExists(File file) {
	 	if  (!file .exists()  && !file .isDirectory()){    
	 	    file .mkdir();    
	 	}
	 }
    
}