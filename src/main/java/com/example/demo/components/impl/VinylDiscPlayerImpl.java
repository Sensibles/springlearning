package com.example.demo.components.impl;

import org.springframework.stereotype.Component;

import com.example.demo.components.VinylDiscPlayer;

@Component
public class VinylDiscPlayerImpl implements VinylDiscPlayer {

	@Override
	public String playVinylNo(int noOfVinyl) {
		
		return ("Odtwarzam płyte winylową numer: "+noOfVinyl);
	}

}
