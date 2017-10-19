package com.lwcsd.model;

public class AccessToken {
	
    private String accessToken;  
    // 凭证有效期，单位：秒  
    private int expiresIn;  

	public void setAccessToken(String acessToken) {
		this.accessToken = acessToken;
	}

	public String getAccessToken() {  
        return accessToken;  
    }  
  
    public int getExpiresIn() {  
        return expiresIn;  
    }  
  
    public void setExpiresIn(int expiresIn) {  
        this.expiresIn = expiresIn;  
    } 
    
    public String toString() {
    	String str = "{ access_token: " + this.getAccessToken() + ", expiresIn: "+ this.getExpiresIn() +"}";
    	return str;
    }
}
