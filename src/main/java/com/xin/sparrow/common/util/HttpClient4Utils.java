
package com.xin.sparrow.common.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * httpClient4 工具类
 * @author: yingjie.wang    
 * @since : 2015-09-23 13:12
 * 61d554fb63c543dda4cbe2509aca18f8
7f88762e427043829b7dac322f0195d7
91b172835ab140c390c478bdbc8807de
c103e80ffbd74218aba6556422ec3838
d32f92e6c5594bfc9afc636d6aec4cf7
ec9a1eb5120c431bb0bcab308035bfc7
 */

public class HttpClient4Utils {
	
	public static void main(String[] args) throws InterruptedException {
        String url = "http://fundgz.1234567.common.cn/js/004224.js?rt=1626166260458";//结果公告
        String sendHttpRequest = HttpClient4Utils.httpGet(url, null,"UTF-8", 5);
        System.out.println(sendHttpRequest);
        System.out.println(System.currentTimeMillis());
    }



	//设置默认超时时间为60s
	public static final int DEFAULT_TIME_OUT	= 60*1000;
	
	//http请求
	public static String sendHttpRequest(String url, Map<String, String> paramMap, String charset, boolean isPost) {
		return sendHttpRequest(url, paramMap, charset, isPost, DEFAULT_TIME_OUT);
	}
	
	//http请求
	public static String sendHttpRequest(String url, Map<String, String> paramMap, String charset, boolean isPost, int timeout) {
		if(isPost) {
			return httpPost(url, paramMap, charset, timeout);
		}
		
		return httpGet(url, paramMap, charset, timeout);
	}
	
		//post请求
		public static String httpPostJson(String url, String regJson, String charset, int timeout) {
			if(url == null || url.equals("")) {
				return null;
			}
			String result		= null;
			//超时设置
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeout).setSocketTimeout(timeout).build();
			CloseableHttpClient httpClient 	= HttpClients.createDefault();
			HttpPost httpPost 				= null;
			String responseBody 			= null;
			CloseableHttpResponse response	= null;
			try {
				httpPost = new HttpPost(url);
				httpPost.setConfig(requestConfig);
				httpPost.setHeader("Content-Type", "menu/json");
				httpPost.setHeader("X-AUTH-TOKEN", "DEFAULT_USER_001_eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkdGZ6c3VwcGVybWFuIiwic3ViIjoiZHRmenN1cHBlcm1hbiIsImlhdCI6MTYyNTYyMDg5N30.aNi7Ot4Q1IVsql_DJ3WEAuNPygG6b1v11hMwmImrly4");
				httpPost.setEntity(new StringEntity(regJson,"UTF-8"));
				response = httpClient.execute(httpPost);
				
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode != 200) {
					httpPost.abort();
					throw new RuntimeException("HttpClient,error status code :" + statusCode);
				}
				HttpEntity entity 	= response.getEntity();
				responseBody 		= EntityUtils.toString(entity, charset);
				result				= responseBody; 
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					// 关闭连接,释放资源  
					if (response != null) {
						response.close();
					}
					if (httpClient != null) {
						httpClient.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			return result;
		}
	
	//post请求
	public static String httpPost(String url, Map<String, String> params, String charset, int timeout) {
		
		if(url == null || url.equals("")) {
			return null;
		}
		
		String result		= null;
		
		//超时设置
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeout).setSocketTimeout(timeout).build();
		
		//参数组装
		List<NameValuePair> pairs	= new ArrayList<NameValuePair>();
		for(Entry<String, String> entry : params.entrySet()) {
			String key		= entry.getKey();
			String value	= entry.getValue();
			pairs.add(new BasicNameValuePair(key, formatStr(value)));
		}

		CloseableHttpClient httpClient 	= HttpClients.createDefault();
		HttpPost httpPost 				= null;
		String responseBody 			= null;
		CloseableHttpResponse response	= null;

		try {
			httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			httpPost.setHeader("Content-Type", "menu/json");
			httpPost.setEntity(new UrlEncodedFormEntity(pairs));
			response = httpClient.execute(httpPost);
			
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpPost.abort();
				throw new RuntimeException("HttpClient,error status code :" + statusCode);
			}
			
			HttpEntity entity 	= response.getEntity();
			responseBody 		= EntityUtils.toString(entity, charset);
			result				= responseBody; 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭连接,释放资源  
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

    //get请求
    public static String httpGet(String url, Map<String, String> params, String charset, int timeout) {
        return httpGet(url, params, null, charset, timeout);
    }

	public static String httpGet(String url, Map<String, String> params,Map<String, String> headers, String charset, int timeout) {
		if(url == null || url.equals("")) {
			return null;
		}
		CloseableHttpClient httpClient 	= HttpClients.createDefault();
		String responseBody 			= null;
		CloseableHttpResponse response	= null;
		try {
			if(params != null && !params.isEmpty()) {
				List<NameValuePair> pairs	= new ArrayList<>();
				for(Entry<String, String> entry : params.entrySet()) {
					String key		= entry.getKey();
					String value	= entry.getValue();
					pairs.add(new BasicNameValuePair(key, formatStr(value)));
				}
				url = url + "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
			}
            HttpGet httpGet = new HttpGet(url);
            if(headers != null && !headers.isEmpty()) {
                for(Entry<String, String> entry : headers.entrySet()) {
                    String key		= entry.getKey();
                    String value	= entry.getValue();
                    httpGet.setHeader(key,value);
                }
            }
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(timeout).setConnectionRequestTimeout(timeout)
                    .setSocketTimeout(timeout).build();
            httpGet.setConfig(requestConfig);
            response	= httpClient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpGet.abort();
				throw new RuntimeException("HttpClient,error status code :" + statusCode);
			}
			HttpEntity entity 	= response.getEntity();
			responseBody 		= EntityUtils.toString(entity, charset);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭连接,释放资源  
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
		
		return responseBody;
	}
	
    private static String formatStr(String text) {
		return (text == null ? "" : text.trim());
	}
	

}
