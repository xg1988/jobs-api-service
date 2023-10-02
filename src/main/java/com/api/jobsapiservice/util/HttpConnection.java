package com.api.jobsapiservice.util;

import com.api.jobsapiservice.contants.BaseConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
@Slf4j
public class HttpConnection {
    public String call(String callUrl, String method) {
        return call(callUrl, method, null, "");
    }
    public String call(String callUrl, String method, String userAgent, String data) {
        log.info("callUrl : {}", callUrl);
        log.info("method : {}", method);
        log.info("userAgent : {}", userAgent);
        log.info("data : {}", data);

        String response = null;

        try {
            URL url = new URL(callUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(method);

            if(BaseConst.POST_REQUEST_METHOD.equals(method)){
                log.info("POST_REQUEST_METHOD called..");
                connection.setRequestProperty("Content-Type", "application/json; utf-8");
                connection.setRequestProperty("Accept", "application/json");

                connection.setDoOutput(true);
                OutputStream os = connection.getOutputStream();
                try{
                    byte[] input = data.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    os.flush();
                    os.close();
                }
            }

            int responseCode = connection.getResponseCode();
            log.info("responseCode : {}" , responseCode);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String inputLine;

            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuffer.append(inputLine);
            }

            bufferedReader.close();

            response = stringBuffer.toString();
            log.debug("response : {}" , response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
