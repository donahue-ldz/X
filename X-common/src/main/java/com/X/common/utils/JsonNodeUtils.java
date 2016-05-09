package com.X.common.utils;


import org.codehaus.jackson.JsonNode;

import java.io.StringWriter;
import java.util.Date;
import java.util.Map;

/**
 * Created by yuzhong.fw on 15/4/27.
 */
public class JsonNodeUtils {
    static public String getStringField(String attribute, JsonNode jsonNode){
        JsonNode attributeJN = jsonNode.get(attribute);
        if(attributeJN != null && !attributeJN.isNull()){
            return attributeJN.asText();
        }
        return null;
    }


    static public Date getDateField(String attribute, JsonNode jsonNode){
        JsonNode dateTime = jsonNode.get(attribute);
        if(dateTime != null && !dateTime.isNull()){
            Date date = new Date(dateTime.asLong());
            return date;
        }
        return null;
    }

    static public String map2Json(Map<String,String> values){
        StringWriter sw = new StringWriter();
        synchronized (sw.getBuffer()) {
            sw.append("{");
            int size = values.size();
            int i = 0;
            for(Map.Entry<String,String> entry : values.entrySet()){
                sw.append("\"");
                sw.append(entry.getKey());
                sw.append("\":");
                sw.append("\"");
                sw.append(entry.getValue());
                sw.append("\"");
                if(size != ++i){
                    sw.append(",");
                }
                sw.append("\n");
            }
            sw.append("}");
        }
        return sw.toString();
    }
}
