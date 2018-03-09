package com.example.demo.components;

import java.util.List;

public interface CdPlayer {
	String playInsertedDisc();
	
	default String playListOfSongs() {
		return "no Songs on the list";
	}
}
