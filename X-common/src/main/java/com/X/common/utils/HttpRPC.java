package com.X.common.utils;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class HttpRPC {
	private static CloseableHttpClient httpClient;
	private static volatile boolean inited = false;
	private static void init(){
		if(!inited){
			PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
			cm.setMaxTotal(200);
			cm.setDefaultMaxPerRoute(20);
			SocketConfig socketConfig = SocketConfig.custom()
		            .setTcpNoDelay(true).setSoTimeout(900*1000)
		            .build();
			cm.setDefaultSocketConfig(socketConfig);
			RequestConfig defaultRequestConfig = RequestConfig.custom()
		            .setExpectContinueEnabled(true)
		            .setConnectTimeout(5000)
		            .setConnectionRequestTimeout(5000)
		            .build();
			ConnectionKeepAliveStrategy myStrategy = new KeepAliveStrategy();
			httpClient = HttpClients.custom().setKeepAliveStrategy(myStrategy)
			        .setConnectionManager(cm).setDefaultRequestConfig(defaultRequestConfig)
			        .build();
			IdleConnectionMonitorThread connMgr = new IdleConnectionMonitorThread(cm);
			connMgr.setDaemon(true);
			connMgr.start();
			inited = true;
		}
	}
	
	public static URIBuilder getURIBuilder(){
		return new URIBuilder();
	}
	
	public static Response get(URI uri) throws ClientProtocolException, IOException{
		return get(uri,null,0);
	}
	
	public static Response get(URI uri,Map<String,String> header) throws ClientProtocolException, IOException{
		return get(uri,header,0);
	}
	
	public static Response get(URI uri,Map<String,String> header,int timeout) throws ClientProtocolException, IOException{
		init();
		Response rt = new Response();
		HttpGet httpGet = new HttpGet(uri);
		if(timeout>=50){
			RequestConfig reqcfg = RequestConfig.custom().setSocketTimeout(timeout).build();
			httpGet.setConfig(reqcfg);
		}
		if(header != null && header.size()>0){
			for(Entry<String,String> entry:header.entrySet()){
				httpGet.setHeader(entry.getKey(), entry.getValue());
			}
		}
		CloseableHttpResponse resp = httpClient.execute(httpGet);
		HttpEntity entity = null;
		try{
			entity = resp.getEntity();
			rt.httpStatusCode = resp.getStatusLine().getStatusCode();
			rt.responseContent = EntityUtils.toByteArray(entity);
		}finally{
			if(entity != null){
				try{
					EntityUtils.consume(entity);
				}catch(IOException e){
				}
			}
		}
		return rt;
	}
	
	public static Response post(URI uri,byte[] requestContent) throws ClientProtocolException, IOException{
		return post(uri,null,requestContent,0);
	}
	
	public static Response post(URI uri,Map<String,String> header,byte[] requestContent) throws ClientProtocolException, IOException{
		return post(uri,header,requestContent,0);
	}
	
	public static Response post(URI uri,Map<String,String> header,byte[] requestContent,int timeout) throws ClientProtocolException, IOException{
		init();
		Response rt = new Response();
		HttpPost httpPost = new HttpPost(uri);
		if(requestContent != null && requestContent.length>0){
			ByteArrayEntity entity = new ByteArrayEntity(requestContent);
			httpPost.setEntity(entity);
		}
		if(timeout>=50){
			RequestConfig reqcfg = RequestConfig.custom().setSocketTimeout(timeout).build();
			httpPost.setConfig(reqcfg);
		}
		if(header != null && header.size()>0){
			for(Entry<String,String> entry:header.entrySet()){
				httpPost.setHeader(entry.getKey(), entry.getValue());
			}
		}
		CloseableHttpResponse resp = httpClient.execute(httpPost);
		HttpEntity entity = null;
		try{
			entity = resp.getEntity();
			rt.httpStatusCode = resp.getStatusLine().getStatusCode();
			rt.responseContent = EntityUtils.toByteArray(entity);
		}finally{
			if(entity != null){
				try{
					EntityUtils.consume(entity);
				}catch(IOException e){
				}
			}
		}
		return rt;
	}
	
	public static Response post(URI uri,Map<String,String> formParameters) throws ClientProtocolException, IOException{
		return post(uri,null,formParameters);
	}
	
	public static Response post(URI uri,Map<String,String> header,Map<String,String> formParameters) throws ClientProtocolException, IOException{
		return post(uri,header,formParameters,0);
	}
	
	public static Response post(URI uri,Map<String,String> header,Map<String,String> formParameters,int timeout) throws ClientProtocolException, IOException{
		init();
		Response rt = new Response();
		HttpPost httpPost = new HttpPost(uri);
		if(formParameters != null && formParameters.size()>0){
			List<FormParameter> parameters = new ArrayList<FormParameter>();
			for(Entry<String,String> entry:formParameters.entrySet()){
				parameters.add(new FormParameter(entry.getKey(),entry.getValue()));
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters,Charset.forName("UTF-8"));
			httpPost.setEntity(entity);
		}
		if(timeout>=0){
			RequestConfig reqcfg = RequestConfig.custom().setSocketTimeout(timeout).build();
			httpPost.setConfig(reqcfg);
		}
		if(header != null && header.size()>0){
			for(Entry<String,String> entry:header.entrySet()){
				httpPost.setHeader(entry.getKey(), entry.getValue());
			}
		}
		CloseableHttpResponse resp = httpClient.execute(httpPost);
		HttpEntity entity = null;
		try{
			entity = resp.getEntity();
			rt.httpStatusCode = resp.getStatusLine().getStatusCode();
			rt.responseContent = EntityUtils.toByteArray(entity);
		}finally{
			if(entity != null){
				try{
					EntityUtils.consume(entity);
				}catch(IOException e){
				}
			}
		}
		return rt;
	}
	
	private static class FormParameter implements NameValuePair{
		private String name;
		private String value;
		public FormParameter(String name,String value){
			this.name = name;
			this.value = value;
		}
		public String getName() {
			return name;
		}
		public String getValue() {
			return value;
		}
	}
	
	public static class Response{
		public int httpStatusCode;
		public byte[] responseContent;
	}
	
	private static class KeepAliveStrategy implements ConnectionKeepAliveStrategy{
		public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
	        HeaderElementIterator it = new BasicHeaderElementIterator(
	                response.headerIterator(HTTP.CONN_KEEP_ALIVE));
	        while (it.hasNext()) {
	            HeaderElement he = it.nextElement();
	            String param = he.getName();
	            String value = he.getValue();
	            if (value != null && param.equalsIgnoreCase("timeout")) {
	                try {
	                    return Long.parseLong(value) * 1000;
	                } catch(NumberFormatException ignore) {
	                }
	            }
	        }
	        return 30 * 1000;
		}
	}
	
	private static class IdleConnectionMonitorThread extends Thread {
	    private final HttpClientConnectionManager connMgr;
	    private volatile boolean shutdown;
	    
	    public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
	        super();
	        this.connMgr = connMgr;
	    }
	    @Override
	    public void run() {
	        try {
	            while (!shutdown) {
	                synchronized (this) {
	                    wait(5000);
	                    connMgr.closeExpiredConnections();
	                    connMgr.closeIdleConnections(30, TimeUnit.SECONDS);
	                }
	            }
	        } catch (InterruptedException ex) {
	        }
	    }
	    @SuppressWarnings("unused")
		public void shutdown() {
	        shutdown = true;
	        synchronized (this) {
	            notifyAll();
	        }
	    }
	}
}
