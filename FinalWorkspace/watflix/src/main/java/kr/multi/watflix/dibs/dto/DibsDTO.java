package kr.multi.watflix.dibs.dto;

import java.sql.Timestamp;

public class DibsDTO {
	private int dibs_no;
	private int movie_no;
	private int user_no;
	private Timestamp dibs_date;

	public DibsDTO() {

	}

	public DibsDTO(int dibs_no, int movie_no, int user_no, Timestamp dibs_date) {
		super();
		this.dibs_no = dibs_no;
		this.movie_no = movie_no;
		this.user_no = user_no;
		this.dibs_date = dibs_date;
	}

	@Override
	public String toString() {
		return "DibsDTO [dibs_no=" + dibs_no + ", movie_no=" + movie_no + ", user_no=" + user_no + ", dibs_date="
				+ dibs_date + "]";
	}

	public int getDibs_no() {
		return dibs_no;
	}

	public void setDibs_no(int dibs_no) {
		this.dibs_no = dibs_no;
	}

	public int getMovie_no() {
		return movie_no;
	}

	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public Timestamp getDibs_date() {
		return dibs_date;
	}

	public void setDibs_date(Timestamp dibs_date) {
		this.dibs_date = dibs_date;
	}
}
