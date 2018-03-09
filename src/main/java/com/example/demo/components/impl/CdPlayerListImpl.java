package com.example.demo.components.impl;

import java.util.List;

import com.example.demo.components.CdPlayer;

public class CdPlayerListImpl implements CdPlayer {
	
	List<String> songs;
	
	public CdPlayerListImpl(List<String> songs) {
		this.songs = songs;
	}

	@Override
	public String playInsertedDisc() {
		// TODO Auto-generated method stub
		return null;
	}
}
