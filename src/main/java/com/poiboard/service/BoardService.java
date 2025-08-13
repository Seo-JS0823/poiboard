package com.poiboard.service;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardService {

	public int hitCount(int hit) {
		
		return hit + 1;
	}
    
	public int startCount(int nowpage, int pagings) {
		
		int start = 0;
		
		for(int i = 1; i <= pagings ; i++) {
			if(nowpage == i) {
				
				break;
			}
			
			start += 10;
		}
		
		return start;
	}
    
    
}
