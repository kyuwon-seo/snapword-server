package com.testServer.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;

public class DelSetCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
		
		String set_no = request.getParameter("set_no");
		
		System.out.println("setDelete 시작");
		mapper.delSet(Integer.parseInt(set_no));
		System.out.println("setDelete 완료");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "delRoom");
		
		return map;
	}
}
