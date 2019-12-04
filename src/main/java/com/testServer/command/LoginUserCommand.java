package com.testServer.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.testServer.dao.Mapper;
import com.testServer.domain.TestVO;
import com.testServer.domain.UserVO;

public class LoginUserCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
	
		String user_id = request.getParameter("user_id");
		String user_passwd = request.getParameter("user_passwd");
		
		Map<String, String> loginMap = new HashMap<String,String>();
		loginMap.put("user_id", user_id);
		loginMap.put("user_passwd", user_passwd);
		List<UserVO> userVO = mapper.loginUser(loginMap);
		System.out.println(user_id+" "+user_passwd+" "+userVO.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "loginUser");
		map.put("userVO", userVO);
		
		return map;
		
	}
}
