package com.example.demo.components.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.components.CdPlayer;

@Component
@Scope(
		value=WebApplicationContext.SCOPE_SESSION,
		proxyMode=ScopedProxyMode.TARGET_CLASS)
@Qualifier("old")
public class OldCdPlayerImpl implements CdPlayer {

	@Override
	public String playInsertedDisc() {
		return "Old Cd player ["+this+"]";
	}

}
