package kr.multi.watflix.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.multi.watflix.movie.dao.MovieDAO;
import kr.multi.watflix.movie.dto.MovieDTO;

@Service
public class MovieServiceImpl implements MovieService {

	MovieDAO dao;

	@Autowired
	public MovieServiceImpl(MovieDAO dao) {
		super();
		this.dao = dao;
	}
	
	/////////////메인화면/////////////////////////

	@Override
	public List<MovieDTO> selectMovieAndRating() {
		// TODO Auto-generated method stub
		return dao.selectMovieAndRating();
	}

	@Override
	public MovieDTO selectByMovieNo(int movie_no) {
		return dao.selectByMovieNo(movie_no);
	}

	@Override
	public List<MovieDTO> selectListTotal() {
		return dao.selectListTotal();
	}

	@Override
	public List<MovieDTO> selectListByTitle(String movie_title) {
		return null;
	}

	@Override
	public List<MovieDTO> selectListByCast(int casting_no) {
		return null;
	}

	@Override
	public List<MovieDTO> selectListSortByRating() {
		return dao.selectListSortByRating();
	}

	@Override
	public List<MovieDTO> selectListSortByReview() {
		return dao.selectListSortByReview();
	}
	
	///////////////검색화면/////////////////////////////////////

	@Override
	public List<MovieDTO> searchMovie(String keyword, String sort) {
		// TODO Auto-generated method stub
		return dao.searchMovie(keyword, sort);
	}

	@Override
	public List<MovieDTO> searchMoviePaging(String keyword, String sort, int start, int pageSize) {
		// TODO Auto-generated method stub
		return dao.searchMoviePaging(keyword, sort, start, pageSize);
	}
	
	////////////////////마이 프로필////////////////////////////////////////

	@Override
	public List<MovieDTO> selectReviewedMovieAndRating(int user_no) {
		// TODO Auto-generated method stub
		List<MovieDTO> list = dao.selectReviewedMovieAndRating(user_no);
		return list;
	}

	@Override
	public List<MovieDTO> selectDibbedMovieAndRating(int user_no) {
		List<MovieDTO> list = dao.selectDibbedMovieAndRating(user_no);
		return list;
	}

	

}
