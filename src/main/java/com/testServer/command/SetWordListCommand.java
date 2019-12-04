package com.testServer.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.WordVO;

public class SetWordListCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {

		int set_no = Integer.parseInt(request.getParameter("set_no"));
		System.out.println("{SetWordLIST}set_no is : " + set_no);

		List<WordVO> wordVO = null;
		System.out.println("wordList 시작");
		wordVO = mapper.wordList(set_no);
		System.out.println("wordList 종료");

		System.out.println(wordVO.toString());

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("wordVO", wordVO);
		return map;
	}
}
