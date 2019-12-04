package com.testServer.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.FoldVO;
import com.testServer.domain.RoomVO;

public class AddRoomCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
		
		RoomVO roomVO = new RoomVO();

		String room_name = request.getParameter("room_name");
		String set_no = request.getParameter("set_no");
		String user_id = request.getParameter("user_id");
		System.out.println("roomInsert 시작");
		roomVO.setRoom_name(room_name);
		roomVO.setSet_no(Integer.parseInt(set_no));
		roomVO.setRoom_person(0);
		roomVO.setRoom_check(true);
		roomVO.setRoom_max(3);
		roomVO.setUser_id(user_id);
		System.out.println("roomInsert 시작22");
		mapper.addRoom(roomVO);
		System.out.println("roomInsert 완료");
		int room_no = mapper.roomNo(roomVO);
		System.out.println("room_no 완료");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("room_no", room_no);
		map.put("page", "addRoom");
		
		return map;
	}
}
