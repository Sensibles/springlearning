package com.example.demo.components.impl;



import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.components.CdPlayer;

@Component
@Qualifier("another_param")
public class AnotherParamCdPlayer implements CdPlayer {

	private String msg;
	private List<String> songs;
	
	public AnotherParamCdPlayer(@Value("${magic}") String msg, @Value("#{awesomeSongList.getAllSongs(100)}") List<String> songs) {
		this.msg = msg;
		this.songs = songs;
	}
	@Override
	public String playInsertedDisc() {
		// TODO Auto-generated method stub
		System.out.println("Gram utwory z płyty");
		return msg;
	}
	
	
	@Override
	public String playListOfSongs() {
		String s = "";
		songs = songs.stream()
			.filter(song -> song.matches("(.*)[02468]"))
			.map(song -> {
				if(song.matches("(.*)[48]"))
						song="<b>"+song+"</b>";
				return song;
			})
			.map(song -> song += "</br>")
			.map(String::toUpperCase)		
			.collect(Collectors.toList());
		
		for(String song : songs)
			s+=song;
		return s;
	}


}
