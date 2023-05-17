package kr.multi.watflix.casting.dto;

import kr.multi.watflix.movie.dto.MovieDTO;

public class CastingMovieDTO {
	private int casting_movie_no;
	private int casting_no;
	private int movie_no;
	
	public CastingMovieDTO() {
		
	}
	
	public CastingMovieDTO(int casting_movie_no, int casting_no, int movie_no) {
		super();
		this.casting_movie_no = casting_movie_no;
		this.casting_no = casting_no;
		this.movie_no = movie_no;
	}
	
	
	@Override
	public String toString() {
		return "CastingMovieDTO [casting_movie_no=" + casting_movie_no + ", casting_no=" + casting_no + ", movie_no="
				+ movie_no + "]";
	}


	public int getCasting_movie_no() {
		return casting_movie_no;
	}
	public void setCasting_movie_no(int casting_movie_no) {
		this.casting_movie_no = casting_movie_no;
	}
	public int getCasting_no() {
		return casting_no;
	}
	public void setCasting_no(int casting_no) {
		this.casting_no = casting_no;
	}
	public int getMovie_no() {
		return movie_no;
	}
	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}

	
}
