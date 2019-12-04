package com.testServer.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.command.Command;
import com.testServer.dao.Mapper;
import com.testServer.domain.FoldVO;
import com.testServer.domain.TestVO;

public class TestPageCommand implements Command{

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
		List<FoldVO> testList = mapper.testList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "testPage");
		map.put("testList", testList);
		return map;
	}
}