package com.testServer.command;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.testServer.dao.Mapper;
import com.testServer.domain.RoomVO;
import com.testServer.domain.SetVO;

public class RoomListCommand implements Command {

	@Override
	public Map<String, Object> command(HttpServletRequest request, Mapper mapper) {
	
		List<RoomVO> roomVO = null;
		System.out.println("roomList 시작");
		roomVO = mapper.roomList();
		System.out.println("roomList 종료");

		String s = new SimpleDateFormat("MM/dd/yyyy").format(roomVO.get(0).getRoom_date());
		System.out.println(s);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("roomVO", roomVO);
		return map;	
	}
}
