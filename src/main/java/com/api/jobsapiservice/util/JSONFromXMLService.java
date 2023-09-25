package com.api.jobsapiservice.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JSONFromXMLService {


    public JSONObject getJSONObjecFromXML(String xml) {
        return XML.toJSONObject(xml);
    }

    public JSONObject getJSONObjectDepth(JSONObject targetObject, String... key) {
        JSONObject returnObject = new JSONObject();
        for (int i = 0; i < key.length; i++) {
            if(i==0) {
                returnObject = (JSONObject) targetObject.get(key[i]);
            }else {
                returnObject = (JSONObject) returnObject.get(key[i]);
            }

        }
        return returnObject;
    }

    public Map<String, Object> getMapFromJSONObject(JSONObject jsonObject){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        if(jsonObject != JSONObject.NULL) {
            returnMap = toMap(jsonObject);
        }
        return returnMap;
    }

    public Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if(value instanceof JSONArray) {
                System.out.println(key);
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }
}
