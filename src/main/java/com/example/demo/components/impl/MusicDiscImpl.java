package com.example.demo.components.impl;

import org.springframework.stereotype.Component;

import com.example.demo.components.MusicDisc;

@Component
public class MusicDiscImpl implements MusicDisc{
	
	private String title, author;
	
	public MusicDiscImpl() {
		title = "Title";
		author = "Author";
	}
	
	public String play() {
		return "Now playing: "+author+": '"+title+"'.";
	}

}
