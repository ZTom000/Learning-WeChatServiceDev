package com.lwcsd.init;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.lwcsd.model.AccessToken;
import com.lwcsd.util.AccessTokenUtil;

@Component
public class AccessTokenInit {
	@PostConstruct
	public void init() {

		AccessToken at = new AccessToken();
		at = AccessTokenUtil.getAccessToken();
		if(at != null) {
			System.out.println(at.toString());
		}
	}

}
