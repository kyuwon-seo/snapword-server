package com.testServer.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;

public class DelFolderCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
		
		String folder_no = request.getParameter("folder_no");
		
		System.out.println("folderDelete 시작");
		mapper.delFolder(Integer.parseInt(folder_no));
		System.out.println("folderDelete 완료");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "delRoom");
		
		return map;
	}
}
