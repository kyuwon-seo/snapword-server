package com.testServer.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.SetVO;

public class SetAllReqCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
	
		String user_id = (request.getParameter("user_id")).toString();
		System.out.println("user_id is : "+user_id);
	
		List<SetVO> setVO = null;
		System.out.println("setAllList 시작");
		setVO = mapper.setAllReq(user_id);
		System.out.println("setList 종료");
		
		System.out.println(setVO.toString());
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("setVO", setVO);
		return map;
		
	}
}