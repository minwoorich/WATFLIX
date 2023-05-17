package kr.multi.watflix.review.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.multi.watflix.review.dto.ReviewDTO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	SqlSession sqlsession;
	@Autowired
	public ReviewDAOImpl(SqlSession sqlsession) {
		super();
		this.sqlsession = sqlsession;
	}
	@Override
	public List<ReviewDTO> selectall(int movie_no) {
		return sqlsession.selectList("kr.multi.watflix.review.dto.selectall",movie_no);
	}
	@Override
	public double selectAvgRating(int movie_no) {
		return sqlsession.selectOne("kr.multi.watflix.review.dto.selectAvgRating", movie_no);
	}
	@Override
	public int insert(ReviewDTO review) {
		return sqlsession.insert("kr.multi.watflix.review.dto.insert", review);
	}
	@Override
	public List<ReviewDTO> selectReviewListByUserNoAndMovieNo(int movie_no, int user_no) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("movie_no", movie_no);
		map.put("user_no", user_no);
		return sqlsession.selectList("kr.multi.watflix.review.dto.selectReviewListByUserNoAndMovieNo", map);
	}

}
