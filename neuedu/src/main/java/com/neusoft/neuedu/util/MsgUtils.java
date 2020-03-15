package com.neusoft.neuedu.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

public class MsgUtils {
	
/*	public static void main(String[] args) {
		String code = new MsgUtils().getCode("15536037941");
		System.out.println(code);
	}*/
	
	// 返回验证码
	public static String getCode(String phone) {
		String host = "https://feginesms.market.alicloudapi.com";
	    String path = "/codeNotice";
	    String method = "GET";
	    String appcode = "7cf19b35923c4f57ba3071813fadd38f";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    Random random = new Random();
	    StringBuilder stringBuilder = new StringBuilder();
	    for(int i=0;i<6;i++) {
	    	int nextInt = random.nextInt(10);
	    	stringBuilder.append(nextInt);
	    }
	    querys.put("param", stringBuilder.toString());
	    querys.put("phone", phone);
	    querys.put("sign", "175622");
	    querys.put("skin", "1");
        //JDK 1.8示例代码请在这里下载：  http://code.fegine.com/Tools.zip
	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
                * 或者直接下载：
                * http://code.fegine.com/HttpUtils.zip
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
                * 相关jar包（非pom）直接下载：
                * http://code.fegine.com/aliyun-jar.zip
	    	*/
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	//System.out.println(response.toString());如不输出json, 请打开这行代码，打印调试头部状态码。
                //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
	    	//获取response的body
	    	System.out.println(EntityUtils.toString(response.getEntity()));
	    	return stringBuilder.toString();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return stringBuilder.toString();
	}
}