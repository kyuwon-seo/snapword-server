package com.testServer.domain;

public class WordVO {
	private int word_no;
	private String word_a;
	private String word_b;
	private String hint;
	private String img_name;
	private int set_no;
	
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public int getWord_no() {
		return word_no;
	}
	public void setWord_no(int word_no) {
		this.word_no = word_no;
	}
	public String getWord_a() {
		return word_a;
	}
	public void setWord_a(String word_a) {
		this.word_a = word_a;
	}
	public String getWord_b() {
		return word_b;
	}
	public void setWord_b(String word_b) {
		this.word_b = word_b;
	}
	public int getSet_no() {
		return set_no;
	}
	public void setSet_no(int set_no) {
		this.set_no = set_no;
	}
}
