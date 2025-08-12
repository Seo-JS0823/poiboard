package com.poiboard.service;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardService {

	public int hitCount(int hit) {
		
		return hit + 1;
	}
    
    
    
}
