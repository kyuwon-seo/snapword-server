package com.testServer.domain;

public class SetVO {

	private int set_no;
	private String set_name;
	private String owner_id;
	private int folder_no;
	private String user_id;
	private int word_cnt;
	
	public int getWord_cnt() {
		return word_cnt;
	}
	public void setWord_cnt(int word_cnt) {
		this.word_cnt = word_cnt;
	}
	public int getSet_no() {
		return set_no;
	}
	public void setSet_no(int set_no) {
		this.set_no = set_no;
	}
	public String getSet_name() {
		return set_name;
	}
	public void setSet_name(String set_name) {
		this.set_name = set_name;
	}
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public int getFolder_no() {
		return folder_no;
	}
	public void setFolder_no(int folder_no) {
		this.folder_no = folder_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
