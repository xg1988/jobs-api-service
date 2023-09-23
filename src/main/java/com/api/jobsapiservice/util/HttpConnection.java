package com.api.jobsapiservice.util;

import com.api.jobsapiservice.contants.BaseConst;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class HttpConnection {
    public String call(String callUrl, String method) {
        return call(callUrl, method, null, null);
    }
    public String call(String callUrl, String method, String userAgent, String data) {
        String response = null;

        try {
            URL url = new URL(callUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(method);
            connection.setRequestProperty(BaseConst.USER_AGENT, userAgent);
            connection.setDoOutput(true);

            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            if(BaseConst.POST_REQUEST_METHOD.equals(method)) outputStream.writeBytes(data);
            outputStream.flush();
            outputStream.close();

            int responseCode = connection.getResponseCode();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String inputLine;

            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuffer.append(inputLine);
            }

            bufferedReader.close();

            response = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
