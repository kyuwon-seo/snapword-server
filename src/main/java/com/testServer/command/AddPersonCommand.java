package com.testServer.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.RoomVO;

public class AddPersonCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
		
		RoomVO roomVO = new RoomVO();

		String room_no = request.getParameter("room_no");
		String room_person = request.getParameter("room_person");

		roomVO.setRoom_no(Integer.parseInt(room_no));
		roomVO.setRoom_person(Integer.parseInt(room_person));
		System.out.println("roomUpdate 시작");
		mapper.addPerson(roomVO);
		System.out.println("roomUpdate 완료");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "Update Clear");
		
		return map;
	}
}
