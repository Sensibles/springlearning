package com.example.demo.components.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.components.CdPlayer;
import com.example.demo.components.MusicDisc;

@Component
public class CdPlayerImpl implements CdPlayer{
	
	@Autowired
	MusicDisc musicDisc;
	
	public String playInsertedDisc() {
		return "["+CdPlayerImpl.class.getName()+"]: "+musicDisc.play();
	}
	

}
