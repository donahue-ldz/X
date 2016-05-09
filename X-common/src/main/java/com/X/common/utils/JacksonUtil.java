package com.X.common.utils;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class JacksonUtil {
	private static ObjectMapper mapper;
	
	/**
	 * 获取ObjectMapper实例
	 * @param createNew 方式：true，新实例；false,存在的mapper实例
	 * @return
	 */
	public static synchronized ObjectMapper getMapperInstance(boolean createNew) {   
        if (createNew) {   
            return new ObjectMapper();   
        } else if (mapper == null) {   
            mapper = new ObjectMapper();   
        }   
        return mapper;   
    }

    public static String toPrettyJson(String json){
        if (StringUtils.isBlank(json)) {
            return json;
        }
        try {
            ObjectMapper objectMapper = JacksonUtil.getMapperInstance(false);
            JsonNode node = objectMapper.readTree(json);
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
        } catch (Exception e) {
            return json;
        }
    }
	
	/**
	 * 将java对象转换成json字符串
	 * @param obj 准备转换的对象
	 * @return json字符串
	 * @throws Exception 
	 */
	public static String beanToJson(Object obj) throws Exception {
		try {
			ObjectMapper objectMapper = getMapperInstance(false);
			String json =objectMapper.writeValueAsString(obj);
			return json;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}
	
	/**
	 * 将java对象转换成json字符串
	 * @param obj 准备转换的对象
	 * @param createNew ObjectMapper实例方式:true，新实例;false,存在的mapper实例
	 * @return json字符串
	 * @throws Exception
	 */
	public static String beanToJson(Object obj,Boolean createNew) throws Exception {
		try {
			ObjectMapper objectMapper = getMapperInstance(createNew);
			String json =objectMapper.writeValueAsString(obj);
			return json;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}
	
	/**
	 * 将json字符串转换成java对象
	 * @param json 准备转换的json字符串
	 * @param cls  准备转换的类
	 * @return 
	 * @throws Exception 
	 */
	public static Object jsonToBean(String json, Class<?> cls) throws Exception {
		try {
		ObjectMapper objectMapper = getMapperInstance(false);
		Object vo = objectMapper.readValue(json, cls);
		return vo;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	/**
	 * 将json字符串转换成java对象
	 * @param json 准备转换的json字符串
	 * @param cls  准备转换的类
	 * @param createNew ObjectMapper实例方式:true，新实例;false,存在的mapper实例
	 * @return
	 * @throws Exception
	 */
	public static Object jsonToBean(String json, Class<?> cls,Boolean createNew) throws Exception {
		try {
		ObjectMapper objectMapper = getMapperInstance(createNew);
		Object vo = objectMapper.readValue(json, cls);
		return vo;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}	
	}

}
