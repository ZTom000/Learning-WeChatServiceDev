package com.lwcsd.init;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.lwcsd.model.AccessToken;
import com.lwcsd.util.AccessTokenUtil;
import com.lwcsd.util.MenuUtil;

@Component
public class AccessTokenInit {
	@PostConstruct
	public void init() {

		AccessToken at = new AccessToken();
		at = AccessTokenUtil.getAccessToken();
		MenuUtil menu = new MenuUtil();
		if(at != null) {
			menu.setAccessToken(at);
			menu.createMenu();
		}
	}

}
