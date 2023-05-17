package kr.multi.watflix.stillcut.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class StillcutDTO {
	private int stillcut_no;
	private String stillcut_image;
	
	public StillcutDTO() {
		
	}
	
	public StillcutDTO(int stillcut_no, String stillcut_image) {
		super();
		this.stillcut_no = stillcut_no;
		this.stillcut_image = stillcut_image;
	}
	
	@Override
	public String toString() {
		return "StillcutDTO [stillcut_no=" + stillcut_no + ", stillcut_image=" + stillcut_image + "]";
	}

	public int getStillcut_no() {
		return stillcut_no;
	}
	public void setStillcut_no(int stillcut_no) {
		this.stillcut_no = stillcut_no;
	}
	public String getStillcut_image() {
		return stillcut_image;
	}
	public void setStillcut_image(String stillcut_image) {
		this.stillcut_image = stillcut_image;
	}
	
}
