package com.poiboard.domain;

import java.util.Objects;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MenuDTO {
	private String menuid;
	private String menuname;
	private int menuseq;
	private int contentCount;
	
	public MenuDTO(String menuid, String menuname, int menuseq, int contentCount) {
		this.menuid = menuid;
		this.menuname = menuname;
		this.menuseq = menuseq;
	}
	
	/* Getter 영역 */
	public String getMenuid() {
		return this.menuid;
	}
	
	public String getMenuname() {
		return this.menuname;
	}
	
	public int getMenuseq() {
		return this.menuseq;
	}
	
	public int getContentCount() {
		return this.contentCount;
	}
	
	/* Setter 영역 */
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	
	public void setMenuseq(int menuseq) {
		this.menuseq = menuseq;
	}
	
	public void setContentCount(int contentCount) {
		this.contentCount = contentCount;
	}
	
	/* toString */
	@Override
	public String toString() {
		return "{\"menuid\":\"" + this.menuid + "\",\"menuname\":\"" + this.menuname + "\",\"menuseq\":\"" + this.menuseq + "\",\"contentCount:\":\"" + this.contentCount + "\"}";
	}
	
	/* hashCode */
	@Override
	public int hashCode() {
		return Objects.hash(menuid, menuname, menuseq);
	}

	/* equals */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuDTO other = (MenuDTO) obj;
		return Objects.equals(menuid, other.menuid) && Objects.equals(menuname, other.menuname)
				&& menuseq == other.menuseq;
	}
	
}
