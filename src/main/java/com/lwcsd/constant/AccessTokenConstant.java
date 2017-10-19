package com.lwcsd.constant;

public abstract class AccessTokenConstant {
	public static final String GRANT_TYPE = "client_credential";
	public static final String APP_ID = "wxba5b9845dc9a185a";
	public static final String APP_SECRET = "d277b0f34aa6de4e85b91e253725ade7";
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type="
												   + GRANT_TYPE + "&appid=" + APP_ID + "&secret=" + APP_SECRET; 
	public static final String MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
}
