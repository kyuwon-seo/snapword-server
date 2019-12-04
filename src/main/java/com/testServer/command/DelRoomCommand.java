package com.testServer.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.RoomVO;

public class DelRoomCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
		
		String room_no = request.getParameter("room_no");
		
		System.out.println("roomDelete 시작");
		mapper.delRoom(Integer.parseInt(room_no));
		System.out.println("roomDelete 완료");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "delRoom");
		
		return map;
	}
}
