package com.testServer.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.json.simple.JSONObject;

import com.testServer.dao.Mapper;
import com.testServer.command.AddCheckCommand;
import com.testServer.command.AddPersonCommand;
import com.testServer.command.AddRoomCommand;
import com.testServer.command.AddSetCommand;
import com.testServer.command.DelFolderCommand;
import com.testServer.command.DelRoomCommand;
import com.testServer.command.DelSetCommand;
import com.testServer.command.FoldListCommand;
import com.testServer.command.FoldMakeCommand;
import com.testServer.command.FoldSearchListCommand;
import com.testServer.command.GetRoomCommand;
import com.testServer.command.LoginUserCommand;
import com.testServer.command.RoomListCommand;
import com.testServer.command.SetAllListCommand;
import com.testServer.command.SetAllReqCommand;
import com.testServer.command.SetListCommand;
import com.testServer.command.SetMakeCommand;
import com.testServer.command.SetSearchListCommand;
import com.testServer.command.SetWordListCommand;
import com.testServer.command.TestPageCommand;
import com.testServer.command.UpdateRoomCommand;
import com.testServer.command.UserSearchListCommand;
import com.testServer.domain.FoldVO;
import com.testServer.domain.RoomVO;
import com.testServer.domain.SetVO;
import com.testServer.domain.TestVO;
import com.testServer.domain.UserVO;
import com.testServer.domain.WordVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private Mapper mapper;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/camera")
	public void camera(HttpServletRequest request) {
		System.out.println("camera 시작");

		String folderTypePath = "/var/lib/tomcat8/webapps/img";
		String name = new String();
		String fileName = new String();
		int sizeLimit = 10 * 1024 * 1024; // 10메가까지 제한 넘어서면 예외발생
		try {
			MultipartRequest multi = new MultipartRequest(request, folderTypePath, sizeLimit,
					new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			// 파일 정보가 있다면
			if (files.hasMoreElements()) {
				name = (String) files.nextElement();
				fileName = multi.getFilesystemName(name);
			}
			System.out.println("이미지를 저장하였습니다. : " + fileName);
		} catch (IOException e) {
			System.out.println("안드로이드 부터 이미지를 받아옵니다.");
		}
	}

	@RequestMapping(value = "/testList")
	public String testList(HttpServletRequest request) {

		TestPageCommand testPageCommand = new TestPageCommand();
		Map<String, Object> map = testPageCommand.command(request, mapper);
		String page = (String) map.get("page");
		List<FoldVO> testList = (List<FoldVO>) map.get("testList");

		if (testList == null) {
			return "home";
		} else {
			System.out.println(testList.get(0).getFolder_name());
		}
		HttpSession session = request.getSession();
		session.setAttribute("testList", testList);
		return page;
	}

	@RequestMapping(value = "/testList2")
	public @ResponseBody List<TestVO> testList2(HttpServletRequest request) {

		TestPageCommand testPageCommand = new TestPageCommand();
		Map<String, Object> map = testPageCommand.command(request, mapper);
		String page = (String) map.get("page");
		List<TestVO> testList = (List<TestVO>) map.get("testList");

		return testList;
	}

	// login 정보 일치 확인하는 메소드
	@RequestMapping(value = "/loginUser")
	public @ResponseBody List<UserVO> loginUser(HttpServletRequest request) {

		LoginUserCommand loginUserCommand = new LoginUserCommand();
		Map<String, Object> map = loginUserCommand.command(request, mapper);

		String page = (String) map.get("page");
		// UserVO userVO = (UserVO) map.get("userVO");
		List<UserVO> userVO = (List<UserVO>) map.get("userVO");

		/*
		 * if(userVO == null) { return "home"; }
		 */
		System.out.println(userVO.get(0).getUser_passwd());
		return userVO;
	}

	// 폴더 목록 보여주기
	@RequestMapping(value = "/foldList")
	public @ResponseBody List<FoldVO> foldList(HttpServletRequest request) {

		FoldListCommand foldListCommand = new FoldListCommand();
		Map<String, Object> map = foldListCommand.command(request, mapper);

		List<FoldVO> foldVO = (List<FoldVO>) map.get("foldVO");
		System.out.println(foldVO.toString());

		return foldVO;
	}

	@RequestMapping(value = "/searchFoldList")
	public @ResponseBody List<FoldVO> searchFoldList(HttpServletRequest request) {

		FoldSearchListCommand foldSearchListCommand = new FoldSearchListCommand();
		Map<String, Object> map = foldSearchListCommand.command(request, mapper);

		List<FoldVO> foldVO = (List<FoldVO>) map.get("foldVO");

		return foldVO;
	}

	@RequestMapping(value = "/searchSetList")
	public @ResponseBody List<SetVO> searchSetList(HttpServletRequest request) {

		SetSearchListCommand setSearchListCommand = new SetSearchListCommand();
		Map<String, Object> map = setSearchListCommand.command(request, mapper);

		List<SetVO> setVO = (List<SetVO>) map.get("setVO");

		return setVO;
	}

	@RequestMapping(value = "/searchUserList")
	public @ResponseBody List<UserVO> searchUserList(HttpServletRequest request) {

		UserSearchListCommand userSearchListCommand = new UserSearchListCommand();
		Map<String, Object> map = userSearchListCommand.command(request, mapper);

		List<UserVO> userVO = (List<UserVO>) map.get("userVO");
		if (userVO.size() >= 0) {
			for (int i = 0; i < userVO.size(); i++) {
				System.out.println(userVO.get(i).getUser_id());
			}
		}

		return userVO;
	}

	// 폴더 만들기 요청 인설트하기
	@RequestMapping(value = "/foldMake")
	public String foldMake(HttpServletRequest request) {

		FoldMakeCommand foldMakeCommand = new FoldMakeCommand();
		Map<String, Object> map = foldMakeCommand.command(request, mapper);

		String page = (String) map.get("page");
		String result = (String) map.get("result");

		if (result != "o") {
			return "home";
		} else {
			System.out.println("폴더생성 완료 ??  " + result);
		}
		HttpSession session = request.getSession();
		session.setAttribute("result", result);
		return page;
	}

	// 방 만들기 요청 인설트하기
	@RequestMapping(value = "/addRoom")
	public String addRoom(HttpServletRequest request) {

		AddRoomCommand addRoomCommand = new AddRoomCommand();
		Map<String, Object> map = addRoomCommand.command(request, mapper);

		String page = (String) map.get("page");
		int room_no = (Integer) map.get("room_no");

		HttpSession session = request.getSession();
		session.setAttribute("room_no", room_no);

		return page;
	}
	@RequestMapping(value = "/delRoom")
	public String delRoom(HttpServletRequest request) {

		DelRoomCommand delRoomCommand = new DelRoomCommand();
		Map<String, Object> map = delRoomCommand.command(request, mapper);

		String page = (String) map.get("page");

		return page;
	}
	@RequestMapping(value = "/delSet")
	public String delSet(HttpServletRequest request) {

		DelSetCommand delSetCommand = new DelSetCommand();
		Map<String, Object> map = delSetCommand.command(request, mapper);

		String page = (String) map.get("page");

		return page;
	}
	@RequestMapping(value = "/delFolder")
	public String delFolder(HttpServletRequest request) {

		DelFolderCommand delFolderCommand = new DelFolderCommand();
		Map<String, Object> map = delFolderCommand.command(request, mapper);

		String page = (String) map.get("page");

		return page;
	}
	@RequestMapping(value = "/getRoom")
	public @ResponseBody RoomVO getRoom(HttpServletRequest request) {

		GetRoomCommand getRoomCommand = new GetRoomCommand();
		Map<String, Object> map = getRoomCommand.command(request, mapper);

		RoomVO roomVO = (RoomVO) map.get("roomVO");

		return roomVO;
	}
	// 방 person 추가
	@RequestMapping(value = "/addPerson")
	public @ResponseBody String addPerson(HttpServletRequest request) {

		AddPersonCommand addPersonCommand = new AddPersonCommand();
		Map<String, Object> map = addPersonCommand.command(request, mapper);
		String page = (String) map.get("page");

		return page;
	}
	// 방 person 추가
		@RequestMapping(value = "/updateRoom")
		public @ResponseBody String updateRoom(HttpServletRequest request) {

			UpdateRoomCommand updateRoomCommand = new UpdateRoomCommand();
			Map<String, Object> map = updateRoomCommand.command(request, mapper);
			String page = (String) map.get("page");

			return page;
		}
	// 방 check 업데이트
	@RequestMapping(value = "/addCheck")
	public @ResponseBody String addCheck(HttpServletRequest request) {

		AddCheckCommand addCheckCommand = new AddCheckCommand();
		Map<String, Object> map = addCheckCommand.command(request, mapper);
		String page = (String) map.get("page");

		return page;
	}

	// 세트 만들기 요청 인설트하기
	@RequestMapping(value = "/setMake")
	public String setMake(@RequestBody Map<String, Object> param, HttpServletRequest request) {

		SetMakeCommand setMakeCommand = new SetMakeCommand();
		Map<String, Object> map = setMakeCommand.setCommand(param, mapper);

		// String page = (String)map.get("page");
		String page = (String) map.get("page");
		String result = (String) map.get("result");
		int set_no = (Integer) map.get("set_no");
		System.out.println("HOMECONT Set_no is " + Integer.toString(set_no));

		HttpSession session = request.getSession();
		if (result.equals("o")) {
			session.setAttribute("result", Integer.toString(set_no));
		} else {
			session.setAttribute("result", result);
		}

		return page;
	}

	// 세트추가 from 폴더
	@RequestMapping(value = "/addSet")
	public String addSet(@RequestBody Map<String, Object> param, HttpServletRequest request) {

		AddSetCommand addSetCommand = new AddSetCommand();
		addSetCommand.setCommand(param, mapper);

		String page = "addSet OK";

		return page;
	}

	// 세트 목록 보여주기
	@RequestMapping(value = "/setList")
	public @ResponseBody List<SetVO> setList(HttpServletRequest request) {

		SetListCommand setListCommand = new SetListCommand();
		Map<String, Object> map = setListCommand.command(request, mapper);

		List<SetVO> setVO = (List<SetVO>) map.get("setVO");

		return setVO;
	}

	// 세트 추가 세트 목록 보여주기
	@RequestMapping(value = "/setAllList")
	public @ResponseBody List<SetVO> setAllList(HttpServletRequest request) {

		SetAllListCommand setAllListCommand = new SetAllListCommand();
		Map<String, Object> map = setAllListCommand.command(request, mapper);

		List<SetVO> setVO = (List<SetVO>) map.get("setVO");

		return setVO;
	}
	// 세트로 보기
	@RequestMapping(value = "/setAllReq")
	public @ResponseBody List<SetVO> setAllReq(HttpServletRequest request) {

		SetAllReqCommand setAllReqCommand = new SetAllReqCommand();
		Map<String, Object> map = setAllReqCommand.command(request, mapper);

		List<SetVO> setVO = (List<SetVO>) map.get("setVO");

		return setVO;
	}
	// 해당 세트클릭시 word 리스트 뿌리기
	@RequestMapping(value = "/setWordList")
	public @ResponseBody List<WordVO> setWordList(HttpServletRequest request) {

		SetWordListCommand setWordListCommand = new SetWordListCommand();
		Map<String, Object> map = setWordListCommand.command(request, mapper);

		List<WordVO> wordVO = (List<WordVO>) map.get("wordVO");

		return wordVO;
	}

	// room 목록 보여주기
	@RequestMapping(value = "/roomList")
	public @ResponseBody List<RoomVO> roomList(HttpServletRequest request) {

		RoomListCommand roomListCommand = new RoomListCommand();
		Map<String, Object> map = roomListCommand.command(request, mapper);

		List<RoomVO> roomVO = (List<RoomVO>) map.get("roomVO");

		return roomVO;
	}

}
