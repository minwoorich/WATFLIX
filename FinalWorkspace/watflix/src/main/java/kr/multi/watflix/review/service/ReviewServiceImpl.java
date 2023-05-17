package kr.multi.watflix.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.multi.watflix.review.dao.ReviewDAO;
import kr.multi.watflix.review.dto.ReviewDTO;

@Service
public class ReviewServiceImpl implements ReviewService {
	ReviewDAO dao;
	@Autowired
	public ReviewServiceImpl(ReviewDAO dao) {
		super();
		this.dao = dao;
	}

	
	@Override
	public double selectAvgRating(int movie_no) {
		return dao.selectAvgRating(movie_no);
	}


	@Override
	public List<ReviewDTO> selectall(int movie_no) {
		// TODO Auto-generated method stub
		return dao.selectall(movie_no);
	}
	@Override
	public int insert(ReviewDTO review) {
		System.out.println(review);
		return dao.insert(review);
	}


	@Override
	public List<ReviewDTO> selectReviewListByUserNoAndMovieNo(int movie_no, int user_no) {
		// TODO Auto-generated method stub
		return dao.selectReviewListByUserNoAndMovieNo(movie_no, user_no);
	}

}
