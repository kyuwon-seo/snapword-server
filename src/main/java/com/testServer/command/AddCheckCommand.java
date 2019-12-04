package com.testServer.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.RoomVO;

public class AddCheckCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
		
		RoomVO roomVO = new RoomVO();

		String room_no = request.getParameter("room_no");
		String check = request.getParameter("room_check");
		boolean room_check = Boolean.valueOf(check);
		
		roomVO.setRoom_no(Integer.parseInt(room_no));
		roomVO.setRoom_check(room_check);
		System.out.println("roomUpdate 시작");
		mapper.addCheck(roomVO);
		System.out.println("roomUpdate 완료");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "Update Clear");
		
		return map;
	}
}