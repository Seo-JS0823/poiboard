package com.poiboard.domain;

import java.sql.Date;

public class UserDTO {
	private String userid;
	private String passwd;
	private String username;
	private String email;
	private int point;
	private Date indate;
	
	/* 다른 생성자가 존재하면 디폴트 생성자는 자동 생성이 안되기 때문에 미리 만들어준다. */
	public UserDTO() {}
	
	public UserDTO(String userid, String passwd, String username, String email, int point, Date indate) {
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
		this.email = email;
		this.point = point;
		this.indate = indate;
	}
	
	/* Setter Group */
	public void setUserid(String userid) {
		if(userid == null) {
			System.out.println("UserDTO setUserid = NULL");
		}
		
		this.userid = userid;
	}
	
	public void setPasswd(String passwd) {
		if(passwd == null) {
			System.out.println("UserDTO setPasswd = NULL");
		}
		this.passwd = passwd;
	}
	
	public void setUsername(String username) {
		if(username == null) {
			System.out.println("UserDTO setUsername = NULL");
		}
		this.username = username;
	}
	
	public void setEmail(String email) {
		if(email == null) {
			System.out.println("UserDTO setEmail = NULL");
		}
		this.email = email;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public void setIndate(Date indate) {
		if(indate == null) {
			System.out.println("UserDTO setIndate = NULL");
		}
		this.indate = indate;
	}
	
	/* Getter Group */
	public String getUserid() {
		return this.userid;
	}
	
	public String getPasswd() {
		return this.passwd;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPoint() {
		return String.format("%,d P", point);
	}
	
	public Date getIndate() {
		return this.indate;
	}
		
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", passwd=" + passwd + ", username=" + username + ", email=" + email
				+ ", point=" + point + ", indate=" + indate + "]";
	}

	public String sendJsonData() {
		return toString().replace("[", "{\"").replaceAll("=", "\":\"").replaceAll(",", "\",\"").replace("]", "\"}");
	}
	
}
