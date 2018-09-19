package com.ecart.service.impl;

import org.springframework.stereotype.Service;

import com.ecart.service.ItestService;

@Service
public class TestServiceImpl implements ItestService{

	
	@Override
	public String test(){
		return "rishi";
	}
}
