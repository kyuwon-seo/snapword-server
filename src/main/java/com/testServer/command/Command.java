package com.testServer.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

import com.testServer.dao.Mapper;

public interface Command {
	public Map<String,Object> command(HttpServletRequest request,Mapper mapper);
}
