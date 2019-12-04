package com.testServer.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.SetVO;
import com.testServer.domain.UserVO;

public class UserSearchListCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
	
		String user_id = "%"+request.getParameter("user_id")+"%";
		System.out.println("UserSearchCommand "+user_id);
		List<UserVO> userVO = mapper.searchUserList(user_id);
		System.out.println(userVO.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("userVO", userVO);
		return map;
		
	}
}
