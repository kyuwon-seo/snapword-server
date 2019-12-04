package com.testServer.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.RoomVO;

public class GetRoomCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {

		RoomVO roomVO = new RoomVO();
		String room_no = request.getParameter("room_no");
		
		System.out.println("getRoom 시작");
		roomVO = mapper.getRoom(Integer.parseInt(room_no));
		System.out.println("getRoom 완료");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roomVO", roomVO);
		
		return map;
	}
}
