package com.example.demo.components.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo.components.CdPlayer;


public class ParamCdPlayerImpl implements CdPlayer {
	
	private String msg;
	
	public ParamCdPlayerImpl(String msg) {
		this.msg = msg;
	}

	@Override
	public String playInsertedDisc() {
		// TODO Auto-generated method stub
		return msg;
	}

}
