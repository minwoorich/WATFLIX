package kr.multi.watflix.review.dto;

import java.sql.Date;

import kr.multi.watflix.movie.dto.MovieDTO;
import kr.multi.watflix.user.dto.UserDTO;

public class ReviewDTO {
	private int Review_no;
	private int user_no;
	private int movie_no;
	private Date review_date;
	private String review_title;
	private String review_content;
	private int rating;
	private MovieDTO movie;
	private UserDTO user;
	
	public ReviewDTO() {
		
	}

	public ReviewDTO(int review_no, int user_no, int movie_no, Date review_date, String review_title,
			String review_content, int rating, MovieDTO movie, UserDTO user) {
		super();
		Review_no = review_no;
		this.user_no = user_no;
		this.movie_no = movie_no;
		this.review_date = review_date;
		this.review_title = review_title;
		this.review_content = review_content;
		this.rating = rating;
		this.movie = movie;
		this.user = user;
	}



	@Override
	public String toString() {
		return "ReviewDTO [Review_no=" + Review_no + ", user_no=" + user_no + ", movie_no=" + movie_no
				+ ", review_date=" + review_date + ", review_content=" + review_content + ", rating=" + rating
				+ ", movie=" + movie + ", user=" + user + "]";
	}

	
	public String getReview_title() {
		return review_title;
	}



	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}



	public int getReview_no() {
		return Review_no;
	}

	public void setReview_no(int review_no) {
		Review_no = review_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getMovie_no() {
		return movie_no;
	}

	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}

	public Date getReview_date() {
		return review_date;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public MovieDTO getMovie() {
		return movie;
	}

	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
