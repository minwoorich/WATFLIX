package kr.multi.watflix.movie.dao;

import java.util.List;

import kr.multi.watflix.movie.dto.MovieDTO;

public interface MovieDAO {
	////////////// 메인 화면//////////////////////////////

	// movie_no 로 영화 가져오기
	MovieDTO selectByMovieNo(int movie_no);

	// 영화 + 별점
	List<MovieDTO> selectMovieAndRating();

	// 모든 영화 출력하기
	List<MovieDTO> selectListTotal();

	// 영화 제목으로 영화 출력
	List<MovieDTO> selectListByTitle(String movie_title);

	// 출연진으로 영화 출력
	List<MovieDTO> selectListByCast(int casting_no);

	// 별점 순으로 출력하기
	List<MovieDTO> selectListSortByRating();

	// 리뷰 많은 순으로 출력
	List<MovieDTO> selectListSortByReview();

	//////////////////// 영화 검색 화면////////////////////////

	// 영화이름/출연진 이름 으로 영화 출력 (별점순)
	List<MovieDTO> searchMovie(String keyword, String sort);

	// 영화이름/출연진 이름 으로 영화 출력 (별점순)
	List<MovieDTO> searchMoviePaging(String keyword, String sort, int start, int pageSize);

	//////////////마이 프로필///////////////////////
	// 영화 + 별점 + 내가 리뷰한
	List<MovieDTO> selectReviewedMovieAndRating(int user_no);

	// 영화 + 별점 + 내가 찜한
	List<MovieDTO> selectDibbedMovieAndRating(int user_no);

}
