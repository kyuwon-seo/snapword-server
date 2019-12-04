package com.testServer.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.FoldVO;

public class FoldSearchListCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
	
		String folder_name = "%"+request.getParameter("folder_name")+"%";
		System.out.println(folder_name);
		Map<String, String> foldSearchMap = new HashMap<String,String>();
		foldSearchMap.put("folder_name", folder_name);
		List<FoldVO> foldVO = mapper.searchFoldList(foldSearchMap);
		System.out.println(foldVO.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("foldVO", foldVO);
		return map;
		
	}
}
