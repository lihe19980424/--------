package com.neusoft.neuedu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	public User() {
		
	}

	public User(Integer id, String userName, String passWord, String email, String phone, String question,
			String answer, byte role, Timestamp create_time, Timestamp update_time, String ip) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.phone = phone;
		this.question = question;
		this.answer = answer;
		this.role = role;
		this.create_time = create_time;
		this.update_time = update_time;
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", email=" + email + ", phone="
				+ phone + ", question=" + question + ", answer=" + answer + ", role=" + role + ", create_time="
				+ create_time + ", update_time=" + update_time + ", ip=" + ip + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public byte getRole() {
		return role;
	}

	public void setRole(byte role) {
		this.role = role;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	private Integer id;
	
	private String userName;
	
	private String passWord;
	
	private String email;
	
	private String phone;
	
	private String question;
	
	private String answer;
	
	private byte role;
	
	private Timestamp create_time;
	
	private Timestamp update_time;
	
	private String ip;
		
}