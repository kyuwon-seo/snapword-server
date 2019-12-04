package com.testServer.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.FoldVO;

public class FoldMakeCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
		
		FoldVO foldVO = new FoldVO();

		String folder_name = request.getParameter("folder_name");
		String user_id = request.getParameter("user_id");
				
		foldVO.setFolder_name(folder_name);
		foldVO.setUser_id(user_id);

		mapper.foldMake(foldVO);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "o");
		map.put("page", "foldMake");
		
		return map;
	}
}
