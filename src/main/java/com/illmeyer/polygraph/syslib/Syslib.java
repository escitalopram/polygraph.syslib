package com.illmeyer.polygraph.syslib;

import java.util.Map;

import com.illmeyer.polygraph.core.Module;

public class Syslib implements Module {

	@Override
	public void init() {
		System.out.println("Initializing Syslib");
	}

	@Override
	public Map<String, Object> createContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}