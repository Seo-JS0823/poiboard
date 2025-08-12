package com.poiboard.service;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserService {
	
	public int plusPoint(int point, String content) {
		
		if(content.length() > 500) {
			if(content.length() > 1000) {
				if(content.length() > 2000) {
					return point + 300;
				}
				return point + 200;
			}
			return point + 100;
		}
		
		return point;
	}
}
