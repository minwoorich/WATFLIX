package kr.multi.watflix.review.dao;

import java.util.List;

import kr.multi.watflix.review.dto.ReviewDTO;

public interface ReviewDAO {
	List<ReviewDTO> selectall(int movie_no);
	List<ReviewDTO> selectReviewListByUserNoAndMovieNo(int movie_no, int user_no);
	double selectAvgRating(int movie_no);
	int insert(ReviewDTO review);
}
