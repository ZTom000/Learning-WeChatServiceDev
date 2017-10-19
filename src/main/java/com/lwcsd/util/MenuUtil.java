package com.lwcsd.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.lwcsd.constant.AccessTokenConstant;
import com.lwcsd.model.AccessToken;
import com.lwcsd.model.WeChatButton;
import com.lwcsd.model.ClickButton;
import com.lwcsd.model.MainButton;
import com.lwcsd.model.SubButtonList;

public class MenuUtil {

	private AccessToken accessToken;
	
	private static Logger log = LoggerFactory.getLogger(MenuUtil.class); 
	
	public void createMenu() {
		String requestUrl = AccessTokenConstant.MENU_URL + accessToken.getAccessToken();
		
//		ClickButton fristButton = new ClickButton();
//		fristButton.setName("测试1");
//		fristButton.setKey("test1");
//		fristButton.setType("click");
//		
//		SubButtonList sbl = new SubButtonList();
//		sbl.setName("测试主菜单");
//		sbl.setSub_button(new WeChatButton[] {fristButton, fristButton, fristButton});
//		
//		MainButton button = new MainButton();
//		button.setButton(new WeChatButton[] {sbl, sbl, sbl});
//		
//		JSONObject buttonList = new JSONObject();
//		
//		buttonList.parseObject(button.toString());
//		
//		System.out.println(buttonList.toJSONString());
		
		String buttonList = " {\r\n" + 
				"     \"button\":[\r\n" + 
				"     {    \r\n" + 
				"          \"type\":\"click\",\r\n" + 
				"          \"name\":\"今日歌曲\",\r\n" + 
				"          \"key\":\"V1001_TODAY_MUSIC\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"           \"type\":\"click\",\r\n" + 
				"           \"name\":\"歌手简介\",\r\n" + 
				"           \"key\":\"V1001_TODAY_SINGER\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"           \"name\":\"菜单\",\r\n" + 
				"           \"sub_button\":[\r\n" + 
				"           {    \r\n" + 
				"               \"type\":\"view\",\r\n" + 
				"               \"name\":\"搜索\",\r\n" + 
				"               \"url\":\"http://www.soso.com/\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"               \"type\":\"view\",\r\n" + 
				"               \"name\":\"视频\",\r\n" + 
				"               \"url\":\"http://v.qq.com/\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"               \"type\":\"click\",\r\n" + 
				"               \"name\":\"赞一下我们\",\r\n" + 
				"               \"key\":\"V1001_GOOD\"\r\n" + 
				"            }]\r\n" + 
				"       }]\r\n" + 
				" }";
		
		JSONObject jsonObject = HttpRequestUtil.httpRequest(requestUrl, "POST", buttonList);
		if(jsonObject != null) {
			try{
				log.error("errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
			}catch (Exception e) {
			}
		}
	}
	public void setAccessToken(AccessToken accessToken) {
		this.accessToken = accessToken;
	}
	
	public AccessToken getAccessToken() {
		return this.accessToken;
	}
}
