package kr.multi.watflix.stillcut.dto;

public class StillcutMovieDTO {
	private int stillcut_movie_no;
	private int stillcut_no;
	private int movie_no;

	public StillcutMovieDTO() {
		super();
	}

	public StillcutMovieDTO(int stillcut_movie_no, int stillcut_no, int movie_no) {
		super();
		this.stillcut_movie_no = stillcut_movie_no;
		this.stillcut_no = stillcut_no;
		this.movie_no = movie_no;
	}

	@Override
	public String toString() {
		return "StillcutMovieDTO [stillcut_movie_no=" + stillcut_movie_no + ", stillcut_no=" + stillcut_no
				+ ", movie_no=" + movie_no + "]";
	}

	public int getStillcut_movie_no() {
		return stillcut_movie_no;
	}

	public void setStillcut_movie_no(int stillcut_movie_no) {
		this.stillcut_movie_no = stillcut_movie_no;
	}

	public int getStillcut_no() {
		return stillcut_no;
	}

	public void setStillcut_no(int stillcut_no) {
		this.stillcut_no = stillcut_no;
	}

	public int getMovie_no() {
		return movie_no;
	}

	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}

}
