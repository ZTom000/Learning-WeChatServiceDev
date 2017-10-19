package com.lwcsd.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.lwcsd.constant.AccessTokenConstant;
import com.lwcsd.model.AccessToken;

public class AccessTokenUtil {
    private static Logger log = LoggerFactory.getLogger(AccessTokenUtil.class);  
    
    /** 
     * 获取access_token 
     *  
     * @param appid 凭证 
     * @param appsecret 密钥 
     * @return 
     */  
    public static AccessToken getAccessToken() {  
        AccessToken accessToken = null;  
      
        String requestUrl = AccessTokenConstant.ACCESS_TOKEN_URL;  
        JSONObject jsonObject = HttpRequestUtil.httpRequest(requestUrl, "GET", null);  
        // 如果请求成功  
        if (null != jsonObject) {  
            try {  
                accessToken = new AccessToken();  
                accessToken.setAccessToken(jsonObject.getString("access_token"));  
                accessToken.setExpiresIn(jsonObject.getIntValue("expires_in"));  
            } catch (JSONException e) {  
                accessToken = null;  
                // 获取token失败  
                log.error("errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));  
            }  
        }  
        return accessToken;  
    }  
}
