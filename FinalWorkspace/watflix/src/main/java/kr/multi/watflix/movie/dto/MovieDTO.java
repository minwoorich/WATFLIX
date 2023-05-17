package kr.multi.watflix.movie.dto;

import java.sql.Timestamp;
import java.util.List;

import kr.multi.watflix.review.dto.ReviewDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MovieDTO {
	private int movie_no;
	private String movie_title;
	private int runningtime;
	private String age;
	private String movie_summary;
	private String movie_image;
	private String genre;
	private Timestamp release_date;
	private String country;
	private List<ReviewDTO> reviews;
	private double avgRating;

	public MovieDTO() {
		super();
	}

	public MovieDTO(int movie_no, String movie_title, int runningtime, String age, String movie_summary,
			String movie_image, String genre, Timestamp release_date, String country, List<ReviewDTO> reviews,
			double avgRating) {
		super();
		this.movie_no = movie_no;
		this.movie_title = movie_title;
		this.runningtime = runningtime;
		this.age = age;
		this.movie_summary = movie_summary;
		this.movie_image = movie_image;
		this.genre = genre;
		this.release_date = release_date;
		this.country = country;
		this.reviews = reviews;
		this.avgRating = avgRating;
	}




	



	public double getAvgRating() {
		return avgRating;
	}
	
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	/*
	 * public MovieDTO(int movie_no, String movie_title, int runningtime, String
	 * age, String movie_summary, String movie_image, String genre, Timestamp
	 * release_date, String country, List<ReviewDTO> reviews) { super();
	 * this.movie_no = movie_no; this.movie_title = movie_title; this.runningtime =
	 * runningtime; this.age = age; this.movie_summary = movie_summary;
	 * this.movie_image = movie_image; this.genre = genre; this.release_date =
	 * release_date; this.country = country; this.reviews = reviews; }
	 */

	@Override
	public String toString() {
		return "MovieDTO [movie_no=" + movie_no + ", movie_title=" + movie_title + ", runningtime=" + runningtime
				+ ", age=" + age + ", movie_summary=" + movie_summary + ", movie_image=" + movie_image + ", genre="
				+ genre + "]";
	}

	public int getMovie_no() {
		return movie_no;
	}

	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public int getRunningtime() {
		return runningtime;
	}

	public void setRunningtime(int runningtime) {
		this.runningtime = runningtime;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMovie_summary() {
		return movie_summary;
	}

	public void setMovie_summary(String movie_summary) {
		this.movie_summary = movie_summary;
	}

	public String getMovie_image() {
		return movie_image;
	}

	public void setMovie_image(String movie_image) {
		this.movie_image = movie_image;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Timestamp getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Timestamp release_date) {
		this.release_date = release_date;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}

}
