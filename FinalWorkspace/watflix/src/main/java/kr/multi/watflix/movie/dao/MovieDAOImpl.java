package kr.multi.watflix.movie.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.multi.watflix.movie.dto.MovieDTO;

@Repository
public class MovieDAOImpl implements MovieDAO {
	SqlSession sqlSession;
	String namespace = "kr.multi.watflix.movie.dto.";

	@Autowired
	public MovieDAOImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	////////////////////////////메인 화면//////////////////
	
	// movie_no로 영화 가져오기
	@Override
	public MovieDTO selectByMovieNo(int movie_no) {
		return sqlSession.selectOne(namespace + "selectByMovieNo", movie_no);
	}

	@Override
	public List<MovieDTO> selectMovieAndRating() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"selectMovieAndRating");
	}

	// 전체 영화 가져오기
	@Override
	public List<MovieDTO> selectListTotal() {
		return sqlSession.selectList(namespace + "selectListTotal");
	}

	// 영화 제목으로 영화 가져오기
	@Override
	public List<MovieDTO> selectListByTitle(String movie_title) {
		return null;
	}

	@Override
	public List<MovieDTO> selectListByCast(int casting_no) {
		return null;
	}

	@Override
	public List<MovieDTO> selectListSortByReview() {

		return sqlSession.selectList(namespace + "selectListSortByReview");
	}

	@Override
	public List<MovieDTO> selectListSortByRating() {
		return sqlSession.selectList(namespace + "selectListSortByRating");
	}

	
	////////////////////////검색 화면 //////////////////////////////
	
	@Override
	public List<MovieDTO> searchMovie(String keyword, String sort) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("keyword", keyword);
		map.put("sort", sort);
		List<MovieDTO> list = sqlSession.selectList(namespace+"searchMovie", map);
		return list;
	}

	@Override
	public List<MovieDTO> searchMoviePaging(String keyword, String sort, int start, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("keyword", keyword);
		map.put("sort", sort);
		map.put("start", Integer.toString(start) );
		map.put("pageSize", Integer.toString(pageSize));
		List<MovieDTO> list = sqlSession.selectList(namespace+"searchMovie", map);
		return list;
	}
	
	
	////////////////////마이 프로필///////////////////////////////////////

	@Override
	public List<MovieDTO> selectReviewedMovieAndRating(int user_no) {
		// TODO Auto-generated method stub
		List<MovieDTO> list = sqlSession.selectList(namespace+"selectReviewedMovieAndRating", user_no);
		return list;
	}

	@Override
	public List<MovieDTO> selectDibbedMovieAndRating(int user_no) {
		List<MovieDTO> list = sqlSession.selectList(namespace+"selectDibbedMovieAndRating", user_no);
		return list;
	}
	
	
	

	

}
