package com.gitsck.controller;

import com.alibaba.fastjson.JSON;
import com.gitsck.entity.TuLin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@RequestMapping("/sendMessage")
	public TuLin sendMessage(String message) throws IOException{
		String APIKEY = "bdc12c0c1e6f4afbb26f28c7628f6a49";
		
		System.out.println(message);
		
		String INFO = URLEncoder.encode(message, "utf-8");
		
		String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
		
		URL getUrl = new URL(getURL);
		
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		
		connection.connect();
		
		// 取得输入流，并使用Reader读取
		BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
		
		StringBuffer sb = new StringBuffer();
		
		String line = "";
		
		while ((line = reader.readLine()) != null) {
			
			sb.append(line);
		} 
		
		reader.close(); 
		// 断开连接
		connection.disconnect(); 
		
		String sbStr = sb.toString();
		
		TuLin tuLin = JSON.parseObject(sbStr, TuLin.class);
		
		System.out.println(tuLin.getCode()+"  |  "+tuLin.getText()); 

		
		return tuLin;
	}

}
