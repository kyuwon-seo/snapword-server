package com.testServer.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.FoldVO;

public class FoldListCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
	
		String user_id = request.getParameter("user_id");
		System.out.println(user_id);
		Map<String, String> foldMap = new HashMap<String,String>();
		foldMap.put("user_id", user_id);
		List<FoldVO> foldVO = mapper.foldList(foldMap);
		System.out.println(foldVO.toString()+" plz");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("foldVO", foldVO);
		return map;
		
	}
}
