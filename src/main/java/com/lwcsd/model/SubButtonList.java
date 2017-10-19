package com.lwcsd.model;

import java.util.List;

public class SubButtonList extends WeChatButton{
	
	private String name;
	private WeChatButton[] sub_button;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WeChatButton[] getSub_button() {
		return sub_button;
	}
	public void setSub_button(WeChatButton[] sub_button) {
		this.sub_button = sub_button;
	}

}
