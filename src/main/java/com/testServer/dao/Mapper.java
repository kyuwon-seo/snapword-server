package com.testServer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.testServer.domain.FoldVO;
import com.testServer.domain.RoomVO;
import com.testServer.domain.SetVO;
import com.testServer.domain.UserVO;
import com.testServer.domain.WordVO;

public interface Mapper {
	public List<FoldVO> testList();
	
	//public UserVO loginUser(Map<String, String> loginMap);
	public List<UserVO> loginUser(Map<String, String> loginMap);
	public List<UserVO> searchUserList(String user_id);
	public List<FoldVO> foldList(Map<String, String> foldMap);
	public List<FoldVO> searchFoldList(Map<String, String> foldMap);
	public List<SetVO> searchSetList(String set_name);
	public List<SetVO> setList(int folder_no);
	public List<SetVO> setAllList(String user_id);
	public List<SetVO> setAllReq(String user_id);
	public List<WordVO> wordList(int set_no);
	public List<RoomVO> roomList();
	public void foldMake(FoldVO foldVO);
	public void addRoom(RoomVO roomVO);
	public void delRoom(int room_no);
	public void delSet(int set_no);
	public void delFolder(int folder_no);
	public RoomVO getRoom(int room_no);
	public void addPerson(RoomVO roomVO);
	public void updateRoom(RoomVO roomVO);
	public void addCheck(RoomVO roomVO);
	public int roomNo(RoomVO roomVO);
	public void wordcnt(int set_no);
	public void setMake(SetVO setVO);
	public void wordMake(Map<String, Object> wordMap);
	public void addSet(Map<String, Object> setMap);
	public SetVO setInfo(@Param("set_name")String set_name, @Param("user_id")String user_id);
}

