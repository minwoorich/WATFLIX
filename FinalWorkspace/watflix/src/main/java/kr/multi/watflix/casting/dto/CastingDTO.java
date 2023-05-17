package kr.multi.watflix.casting.dto;

import java.util.List;


public class CastingDTO {
	private int casting_no;
	private String casting_image;
	private String casting_name;
	private String casting_job;
	
	public CastingDTO() {
		super();
	}

	public CastingDTO(int casting_no, String casting_image, String casting_name, String casting_job) {
		super();
		this.casting_no = casting_no;
		this.casting_image = casting_image;
		this.casting_name = casting_name;
		this.casting_job = casting_job;
	}

	@Override
	public String toString() {
		return "CastingDTO [casting_no=" + casting_no + ", casting_image=" + casting_image + ", casting_name="
				+ casting_name + ", casting_job=" + casting_job + "]";
	}

	public int getCasting_no() {
		return casting_no;
	}

	public void setCasting_no(int casting_no) {
		this.casting_no = casting_no;
	}

	public String getCasting_image() {
		return casting_image;
	}

	public void setCasting_image(String casting_image) {
		this.casting_image = casting_image;
	}

	public String getCasting_name() {
		return casting_name;
	}

	public void setCasting_name(String casting_name) {
		this.casting_name = casting_name;
	}

	public String getCasting_job() {
		return casting_job;
	}

	public void setCasting_job(String casting_job) {
		this.casting_job = casting_job;
	}

}
