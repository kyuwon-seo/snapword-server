package com.testServer.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.SetVO;

public class SetListCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
	
		int folder_no = Integer.parseInt(request.getParameter("folder_no"));
		System.out.println("folder_no is : "+folder_no);
	
		List<SetVO> setVO = null;
		System.out.println("setList 시작");
		setVO = mapper.setList(folder_no);
		System.out.println("setList 종료");
		
		System.out.println(setVO.toString());
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("setVO", setVO);
		return map;
		
	}
}