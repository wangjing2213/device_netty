package com.dearho.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dearho.core.converter.FilePathEnum;
import com.dearho.result.JSONResult;

@RestController
@RequestMapping("${admin.url.prefix}/sys/file")
public class FileUploadController {

	
	@PostMapping("/upload")  
	public JSONResult upload(@RequestParam("upload_file") MultipartFile multipartFile,@RequestParam("pathEnum") FilePathEnum pathEnum ) {  
	  
		  if(multipartFile.isEmpty()){  
		    return JSONResult.AppFailJSONResult("上传文件为空");  
		  } 
		  if(pathEnum==null){  
			    return JSONResult.AppFailJSONResult("文件上传路径为空");  
		  } 
		  if(StringUtils.isEmpty(pathEnum.getPath())){  
			    return JSONResult.AppFailJSONResult("文件上传路径未配置");  
		  } 
		  
		  File file=null;
		  try {
			  file = new File(pathEnum.getPath() + UUID.randomUUID().toString().replace("-", ""));  
			  multipartFile.transferTo(file);
		  } catch (Exception e) {
				e.printStackTrace();
				return JSONResult.AppFailJSONResult("上传文件失败");  
		  } 
		  return JSONResult.AppSuccessJSONResult(file.getName());
	  
	} 
	
	
	@PostMapping("/uploads")  
	public JSONResult upload(@RequestParam("upload_files") MultipartFile[] uploadingFiles,@RequestParam("pathEnum") FilePathEnum pathEnum) {  
	  
		 if(uploadingFiles==null || uploadingFiles.length==0){  
			    return JSONResult.AppFailJSONResult("上传文件为空");  
		 } 
		 if(pathEnum==null){  
			    return JSONResult.AppFailJSONResult("文件上传路径为空");  
		  } 
		  if(StringUtils.isEmpty(pathEnum.getPath())){  
			    return JSONResult.AppFailJSONResult("文件上传路径未配置");  
		  } 
		 Map<String,String> nameMap=new HashMap<String,String>();
		  for(MultipartFile uploadedFile : uploadingFiles) {  
		    File file = new File(pathEnum.getPath() + uploadedFile.getOriginalFilename());  
		    try {
				uploadedFile.transferTo(file);
				nameMap.put(uploadedFile.getOriginalFilename(), file.getName());
			} catch (Exception e) {
				e.printStackTrace();
				return JSONResult.AppFailJSONResult("上传文件失败");
			}  
		  }  
		  return JSONResult.AppSuccessJSONResult(nameMap);
	}  
	
	
	
	@RequestMapping("/download")
	public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
	    String fileName = "1.jpg";// 设置文件名，根据业务需要替换成要下载的文件名
	    if (fileName != null) {
	        //设置文件路径
	        String realPath = "D://";
	        File file = new File(realPath , fileName);
	        if (file.exists()) {
	            response.setContentType("application/force-download");// 设置强制下载不打开
	            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
	            byte[] buffer = new byte[1024];
	            FileInputStream fis = null;
	            BufferedInputStream bis = null;
	            try {
	                fis = new FileInputStream(file);
	                bis = new BufferedInputStream(fis);
	                OutputStream os = response.getOutputStream();
	                int i = bis.read(buffer);
	                while (i != -1) {
	                    os.write(buffer, 0, i);
	                    i = bis.read(buffer);
	                }
	                System.out.println("success");
	            } catch (Exception e) {
	                e.printStackTrace();
	            } finally {
	                if (bis != null) {
	                    try {
	                        bis.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	                if (fis != null) {
	                    try {
	                        fis.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	    }
	    return null;
	}
	
	/** 
     * 上传 
     * @param file 
     * @param request 
     * @return 
     * @throws IOException 
     */  

    private String  uploadFile(MultipartFile file,HttpServletRequest request) throws IOException {  
              String path=request.getSession().getServletContext().getRealPath("upload");  
              String fileName=file.getOriginalFilename();  
              File targetFile=new File(path,fileName);  
              if(!targetFile.exists()){  
                       targetFile.mkdirs();  
              }  
              file.transferTo(targetFile);  
//          request.setAttribute("filePath",targetFile.getAbsolutePath());  
              return    targetFile.getAbsolutePath();  

    } 
	
    @PostMapping("/upload1")  
	public JSONResult upload1(@RequestParam("upload_file") MultipartFile multipartFile,HttpServletRequest request ) {  
	  
		  if(multipartFile.isEmpty()){  
		    return JSONResult.AppFailJSONResult("上传文件为空");  
		  } 
		  
		  
		  File file=null;
		  try {
			  /**
               * 项目服务器地址路径
               */
              String projectServerPath = request.getScheme() + "://"+request.getServerName()+":" +
                              request.getServerPort() + request.getContextPath() + "/upload/";
              System.out.println(projectServerPath);
              /**
               * 上传文件绝对路径
               */
              String path = request.getSession().getServletContext().getRealPath("/");
              System.out.println(path);
              /**
               * 上传文件名
               */
              String fileName = multipartFile.getOriginalFilename();
              System.out.println(fileName);
              file = new File(Constants.UPLOAD_PATH_DRIVING + UUID.randomUUID().toString().replace("-", "") + "_" + multipartFile.getOriginalFilename());
//			  file = new File(pathEnum.getPath() + UUID.randomUUID().toString().replace("-", ""));  
			  multipartFile.transferTo(file);
		  } catch (Exception e) {
				e.printStackTrace();
				return JSONResult.AppFailJSONResult("上传文件失败");  
		  } 
		  return JSONResult.AppSuccessJSONResult(file.getName());
	  
	} 
	
}
