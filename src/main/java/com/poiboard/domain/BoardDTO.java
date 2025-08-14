package com.poiboard.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class BoardDTO {
	/* Board Table */
	private int idx;
	private String menuid;
	private String title;
	private String content;
	private String writer;
	private Timestamp regdate;
	private int hit;
	
	/* 추가로 가져올 놈들 */
	private String username;
	private String menuname;
	private String userid;
	
	/* 페이징 관련 */
	private int startPage;
	private int endPage;
	
	public BoardDTO() {}
	
	public BoardDTO(int idx, String menuid, String title, String content, String writer, Timestamp regdate, int hit) {
		this.idx = idx;
		this.menuid = menuid;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.hit = hit;
	}
	
	public BoardDTO(String username, String menuname, String userid) {
		this.username = username;
		this.menuname = menuname;
		this.userid = userid;
	}
	
	/* Getter 영역 */
	public int getIdx() {
		return this.idx;
	}
	
	public String getMenuid() {
		return this.menuid;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public String getWriter() {
		return this.writer;
	}
	
	public String getRegdate() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH시 mm분");
		return date.format(regdate);
	}
	
	public int getHit() {
		return this.hit;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getMenuname() {
		return this.menuname;
	}
	
	public String getUserid() {
		return this.userid;
	}
	
	public int getStartPage() {
		return this.startPage;
	}
	
	public int getEndPage() {
		return this.endPage;
	}
	
	/* Setter 영역 */
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	/* 동일성 검사 */
	@Override
	public int hashCode() {
		return Objects.hash(idx, menuid, regdate, title, userid, writer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardDTO other = (BoardDTO) obj;
		return idx == other.idx && Objects.equals(menuid, other.menuid) && Objects.equals(regdate, other.regdate)
				&& Objects.equals(title, other.title) && Objects.equals(userid, other.userid)
				&& Objects.equals(writer, other.writer);
	}
	
}
