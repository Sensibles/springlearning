package com.example.demo.components.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.components.SongList;

@Component
public class AwesomeSongList implements SongList {

	@Override
	public List<String> getAllSongs(int size) {
		List<String> list = new ArrayList<>();
		for(int i = 0; i < size; i++) 
			list.add("Piosenka: "+i);	
		return list;
	}

}
