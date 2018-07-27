package com.dearho.util.face.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.activation.MimetypesFileTypeMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;







import com.dearho.util.JsonTools;
import com.dearho.util.StringHelper;
import com.dearho.util.face.vo.DriverLicenseVo;
import com.dearho.util.face.vo.IdCodeVo;
import com.dearho.util.face.vo.VehicleLicenseVo;

import sun.misc.BASE64Encoder;

/**
 * 旷视 FACE++ https://faceid.com
 * 
 * @author LH 2017年7月13日 10:42:35
 */
public class KShiFaceUtil {
	private static Log log = LogFactory.getLog(KShiFaceUtil.class);
	// 检测和识别中华人民共和国第二代身份证 url: "
	private final static String service_url_id_code = "https://api.faceid.com/faceid/v1/ocridcard";

	// 驾驶证
	private final static String service_url_driver_license = "https://api.megvii.com/faceid/v2/ocr_driver_license";

	// 行驶证
	private final static String service_url_vehicle_license = "https://api.megvii.com/faceid/v2/ocr_vehicle_license";

	private final static String service_url_verify="https://api.megvii.com/faceid/v2/verify";
	
	// 人脸分析
	private final static String service_url_face_detect = "https://api-cn.faceplusplus.com/facepp/v3/detect";

	// 人脸比对
	private final static String service_url_face_compare = "https://api-cn.faceplusplus.com/facepp/v3/compare";
	
	private final static String service_url_detect = "https://api.faceid.com/faceid/v1/detect";

	//Api Key
	private final static String api_key = "W85okltTHlsMu-1h2gAxr3XJiDCLJpQr";
	
	//API Secret 用于验证客户身份
	private final static String api_secret = "gFJkuuqwt8GiJmGE-gyNDn_TLyxio3xS";
	
	//测试
	// Api Key
	//private final static String api_key = "9acfS16TUMpKBN15PDrrEsomx9JQAxt6";
	// API Secret 用于验证客户身份
	//private final static String api_secret = "JARAgr982D8AiPdRkQ4W9ZU6TVWWz3BN";

	public static void main(String[] args) {
		// Map<String, Object> map = ocrIdCard(new File("E:\\wangjing.jpg"),"");
		//271bf2a6723f06f867cc94104cc88094
		File file = new File("C:\\Users\\wt911\\Desktop\\33.png");
		System.out.println(ocrIdCard(file, null));
		Map<String, Object> map = KShiFaceUtil.ocrVehicleLicense(file);
		DriverLicenseVo datas = (DriverLicenseVo) map.get("data");
		String license_number = datas.getLicense_number();
		System.out.println(license_number);
		System.out.println(map.get("code"));
//		Map<String, Object> map = KShiFaceUtil.ocrIdCard(file, "1");
//		IdCodeVo datas =  (IdCodeVo) map.get("data"); 
//		String sex = "男".equals(datas.getGender())?"1":"0";
//		System.out.println(sex);
//		String birthDate = datas.getBirthday().get("year") + "-" + datas.getBirthday().get("month") + "-" + datas.getBirthday().get("day");
//		System.out.println(birthDate);
//		System.out.println(verify("黄金伟", "411123199305010014", "", file));
		/*c3e701c0fa8138bfc95967fab4716860
		*/
		//System.out.println(compare(file, file, null));
		/*try {
			System.out.println(encodeBase64File(null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public static String detect_v1(File image) {
		Map<String, String> textMap = new HashMap<String, String>();
		textMap.put("api_key", api_key);
		textMap.put("api_secret", api_secret);
		textMap.put("multi_oriented_detection", "1");
		Map<String, File> fileMap = new HashMap<String, File>();
		fileMap.put("image", image);
		Map<String, Object> map = formUpload(service_url_detect, textMap, fileMap);
		if(map.get("code").equals(0)) {
			Object data = map.get("data");
			Map<String, String> mapJson = JsonTools.jsonForMap(data.toString());
			List<Map<String, Object>> list = JsonTools.parseJSON2List(mapJson.get("faces").toString());
			if (list == null || list.isEmpty()) {
				return null;
			}
			Map<String, Object> faces = list.get(0);
			return faces.get("token").toString();
		}
		return null;
	}
	
	public static Boolean verify(String idcard_name,String idcard_number,String delta,File image_best){
		Map<String, String> textMap = new HashMap<String, String>();
		textMap.put("api_key", api_key);
		textMap.put("api_secret", api_secret);
		textMap.put("comparison_type", "1");
		textMap.put("face_image_type", "facetoken");
		

		textMap.put("idcard_name", idcard_name);
		textMap.put("idcard_number", idcard_number);
		System.out.println(delta);
		textMap.put("face_token", delta);
		/*Map<String, File> fileMap = new HashMap<String, File>();
		fileMap.put("image_best", image_best);*/
		
		Map<String, Object> map = formUpload(service_url_verify, textMap, null);
		if(map.get("code").equals(0)) {
			Object data = map.get("data");
			Map<String, String> mapJson = JsonTools.jsonForMap(data.toString());
			
			Map<String, String> result_faceid = JsonTools.jsonForMap(mapJson.get("result_faceid").toString());
			String confidence = result_faceid.get("confidence");
			Map<String, String> thresholds = JsonTools.jsonForMap(result_faceid.get("thresholds").toString());
			String str_1e_5 = thresholds.get("1e-5");
			if(Float.parseFloat(confidence)>Float.parseFloat(str_1e_5)) {
				return true;
			}else {
				return false;
			}
		}
		return null;
	}
	
	public static String encodeBase64File(File file) throws Exception {
		if(file==null) {
			return null;
		}
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		return new BASE64Encoder().encode(buffer);
	}

	/**
	 * 检测和识别中华人民共和国第二代身份证
	 * 
	 * @param file
	 *            图片
	 * @param legality
	 *            返回身份证照片合法性检查结果
	 */
	public static Map<String, Object> ocrIdCard(File file, String legality) {
		Map<String, String> textMap = new HashMap<String, String>();
		textMap.put("api_key", api_key);
		textMap.put("api_secret", api_secret);
		if (StringHelper.isEmpty(legality) || legality.equals("0")) {
			legality = "0";
		}
		textMap.put("legality", legality);
		Map<String, File> fileMap = new HashMap<String, File>();
		fileMap.put("image", file);
		Map<String, Object> map = formUpload(service_url_id_code, textMap, fileMap);
		if (map.get("code").equals(0)) {
			Object data = map.get("data");
			map.put("data", new IdCodeVo(data.toString()));
		}
		return map;
	}

	/**
	 * 检测和识别中华人民共和国驾驶证-只支持驾照主页面
	 * 
	 * @param file
	 * @return
	 */
	public static Map<String, Object> ocrDriverLicense(File file) {
		Map<String, String> textMap = new HashMap<String, String>();
		textMap.put("api_key", api_key);
		textMap.put("api_secret", api_secret);
		Map<String, File> fileMap = new HashMap<String, File>();
		fileMap.put("image", file);
		Map<String, Object> map = formUpload(service_url_driver_license, textMap, fileMap);
		if (map.get("code").equals(0)) {
			Object data = map.get("data");
			map.put("data", new DriverLicenseVo(data.toString()));
		}
		return map;
	}

	/**
	 * 检测和识别中华人民共和国行驶证-只支持行驶证主页面
	 * 
	 * @param file
	 * @return
	 */
	public static Map<String, Object> ocrVehicleLicense(File file) {
		Map<String, String> textMap = new HashMap<String, String>();
		textMap.put("api_key", api_key);
		textMap.put("api_secret", api_secret);
		Map<String, File> fileMap = new HashMap<String, File>();
		fileMap.put("image", file);
		Map<String, Object> map = formUpload(service_url_vehicle_license, textMap, fileMap);
		if (map.get("code").equals(0)) {
			Object data = map.get("data");
			map.put("data", new VehicleLicenseVo(data.toString()));
		}
		return map;
	}

	public static Map<String, Object> detect(File file,Map<String, String> maps) {
		Map<String, String> textMap = new HashMap<String, String>();
		textMap.put("api_key", api_key);
		textMap.put("api_secret", api_secret);
		String base64File=null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			base64File = encodeBase64File(file);
		} catch (Exception e) {
			map.put("code", "1");
			map.put("msg", "转码异常");
			return map;
		}
		textMap.put("image_base64",base64File);
		if(maps!=null && !maps.isEmpty()) {
			for (Entry<String, String> entrySet : maps.entrySet()) {
				textMap.put(entrySet.getKey(), entrySet.getValue());
			}
		}
		textMap.put("return_landmark", "0");
		map = formUpload(service_url_face_detect, textMap, null);
		if(map.get("code").equals("0")){
			
		}
		return map;
	}

	public static Map<String, Object> compare(File file1,File file2,Map<String, String> maps) {
		Map<String, String> textMap = new HashMap<String, String>();
		textMap.put("api_key", api_key);
		textMap.put("api_secret", api_secret);
		String base64File1=null;
		String base64File2=null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			base64File1 = encodeBase64File(file1);
			base64File2 = encodeBase64File(file2);
		} catch (Exception e) {
			map.put("code", "1");
			map.put("msg", "转码异常");
			return map;
		}
		if(StringHelper.isEmpty(base64File1)) {
			textMap.put("image_base64_1",base64File1);
		}
		if(StringHelper.isEmpty(base64File2)) {
			textMap.put("image_base64_2",base64File2);
		}
		if(maps!=null && !maps.isEmpty()) {
			for (Entry<String, String> entrySet : maps.entrySet()) {
				textMap.put(entrySet.getKey(), entrySet.getValue());
			}
		}
		return formUpload(service_url_face_compare, textMap, null);
	}
	
	/**
	 * 模拟post multipart/form-data的方式上传。
	 * 
	 * @param urlStr
	 * @param textMap
	 * @param fileMap
	 * @return
	 */
	private static Map<String, Object> formUpload(String urlStr, Map<String, String> textMap,
			Map<String, File> fileMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		String res = "";
		HttpURLConnection conn = null;
		String BOUNDARY = "---------------------------5YaF5a6555qE5YiG6ZqU56ym"; // boundary就是request头和上传文件内容的分隔符
		try {
			URL url = new URL(urlStr);

			trustAllHttpsCertificates();
			HostnameVerifier hv = new HostnameVerifier() {
				public boolean verify(String urlHostName, SSLSession session) {
					System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
					return true;
				}
			};
			HttpsURLConnection.setDefaultHostnameVerifier(hv);

			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(30000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
			OutputStream out = new DataOutputStream(conn.getOutputStream());
			// text
			if (textMap != null) {
				StringBuffer strBuf = new StringBuffer();
				Iterator<Entry<String, String>> iter = textMap.entrySet().iterator();
				while (iter.hasNext()) {
					Entry<String, String> entry = iter.next();
					String inputName = entry.getKey();
					String inputValue = entry.getValue();
					if (inputValue == null) {
						continue;
					}
					strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
					strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
					strBuf.append(inputValue);
				}
				out.write(strBuf.toString().getBytes("UTF-8"));//UTF-8编码设置 LH 2018年3月12日 11:56:59
			}

			// file
			if (fileMap != null) {
				Iterator<Entry<String, File>> iter = fileMap.entrySet().iterator();
				while (iter.hasNext()) {
					Entry<String, File> entry = iter.next();
					String inputName = entry.getKey();
					File file = entry.getValue();
					if (file == null) {
						continue;
					}
					String filename = file.getName();
					String contentType = new MimetypesFileTypeMap().getContentType(file);
					if (filename.endsWith(".png")) {
						contentType = "image/png";
					}
					if (contentType == null || contentType.equals("")) {
						contentType = "application/octet-stream";
					}

					StringBuffer strBuf = new StringBuffer();
					strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
					strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename
							+ "\"\r\n");
					strBuf.append("Content-Type:" + contentType + "\r\n\r\n");

					out.write(strBuf.toString().getBytes());

					DataInputStream in = new DataInputStream(new FileInputStream(file));
					int bytes = 0;
					byte[] bufferOut = new byte[1024];
					while ((bytes = in.read(bufferOut)) != -1) {
						out.write(bufferOut, 0, bytes);
					}
					in.close();
				}
			}

			byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
			out.write(endData);
			out.flush();
			out.close();
			// 读取返回数据
			res = getInputStreamStr(conn.getInputStream());
			map.put("data", res);
		} catch (Exception e) {
			System.out.println("发送POST请求出错。" + e.getMessage());
			try {
				String error = getInputStreamStr(conn.getErrorStream());
				Map<String, String> jsonForMap = JsonTools.jsonForMap(error);
				map.put("code", conn.getResponseCode());
				if(jsonForMap.get("error")==null || jsonForMap.get("error").equals("") ) {
					map.put("error", jsonForMap.get("error_message"));
				}else {
					map.put("error", jsonForMap.get("error"));
				}
				

			} catch (Exception e1) {
				log.error(e);
			}
		} finally {
			if (conn != null) {
				conn.disconnect();
				conn = null;
			}
		}
		return map;
	}

	/**
	 * 读取返回数据
	 * 
	 * @param isnputStream
	 * @return
	 * @throws IOException
	 */
	private static String getInputStreamStr(InputStream isnputStream) throws IOException {
		StringBuffer strBuf = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(isnputStream, "utf-8"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			strBuf.append(line).append("\n");
		}
		String str = strBuf.toString();
		reader.close();
		reader = null;
		return str;
	}

	private static void trustAllHttpsCertificates() throws Exception {
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}

	static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}

		public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}
	}
}
