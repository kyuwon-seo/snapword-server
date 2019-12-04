package com.testServer.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.SetVO;

public class SetMakeCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "o");
		map.put("page", "foldMake");

		return map;
	}

	// set 생성 요청 들어오면 set하나 생성 및 세트넘버받기 , word테이블 생성
	public Map<String, Object> setCommand(Map<String, Object> param, Mapper mapper) {

		System.out.println("param is : "+ param.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		String set_name = (String) param.get("set_name");
		String user_id = (String) param.get("user_id");

		SetVO setVO = null;
		setVO = mapper.setInfo(set_name, user_id); // set제목 중복 확인

		if (setVO == null) {
			setVO = new SetVO();
			setVO.setSet_name(set_name);
			setVO.setOwner_id(user_id);
			setVO.setUser_id(user_id);
			
			mapper.setMake(setVO); 
			System.out.println("setMake 완료");
			setVO = null; // setVO 초기화
			setVO = mapper.setInfo(set_name, user_id); // 생성한 set_no 받아오기 위함
			
			int set_no = setVO.getSet_no();
			param.put("set_no", set_no);
			mapper.wordMake(param); // word테이블 삽입
			System.out.println("wordMake 완료");
			
			mapper.wordcnt(set_no);
			
			//String no = ""+Integer.toString(set_no);
			System.out.println("set_no is " + set_no);
			map.put("result", "o");
			map.put("set_no", set_no);
		} else {
			System.out.println("setVO is null : set_name 중복!");
			map.put("result", "x");
		}

		map.put("page", "setMake");

		return map;
	}
}
