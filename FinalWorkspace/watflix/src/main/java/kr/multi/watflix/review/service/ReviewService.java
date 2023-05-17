package kr.multi.watflix.review.service;

import java.util.List;

import kr.multi.watflix.review.dto.ReviewDTO;

public interface ReviewService {
	double selectAvgRating(int movie_no);
	List<ReviewDTO> selectall(int movie_no);
	List<ReviewDTO> selectReviewListByUserNoAndMovieNo(int movie_no, int user_no);
	int insert(ReviewDTO review);
	
}
