package com.testServer.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.SetVO;

public class AddSetCommand{

	// set 생성 요청 들어오면 set하나 생성 및 세트넘버받기 , word테이블 생성
	public void setCommand(Map<String, Object> param, Mapper mapper) {

		System.out.println("param is : " + param.toString());
		mapper.addSet(param);
		System.out.println("AddSet 완료");

	}
}
