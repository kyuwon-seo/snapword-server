package com.testServer.domain;

public class FoldVO {
	private int folder_no;
	private String folder_name;
	private String user_id;
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getFolder_no() {
		return folder_no;
	}
	public void setFolder_no(int folder_no) {
		this.folder_no = folder_no;
	}
	public String getFolder_name() {
		return folder_name;
	}
	public void setFolder_name(String folder_name) {
		this.folder_name = folder_name;
	}
}
