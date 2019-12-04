package com.testServer.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.FoldVO;
import com.testServer.domain.SetVO;

public class SetSearchListCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
	
		String set_name = "%"+request.getParameter("set_name")+"%";
		System.out.println(set_name);
		List<SetVO> setVO = mapper.searchSetList(set_name);
		System.out.println(setVO.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("setVO", setVO);
		return map;
		
	}
}
