package com.example.demo.components.impl;

import com.example.demo.components.DvdPlayer;

public class DvdPlayerProdImpl implements DvdPlayer {

	@Override
	public String play() {
		return "No DVD Disc inserted [Prod]";
	}

}
