package kr.multi.watflix.casting.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.multi.watflix.casting.dto.CastingDTO;
import kr.multi.watflix.movie.dto.MovieDTO;

@Repository
public class CastingDAOImpl implements CastingDAO {
	SqlSession sqlSession;
	
	@Autowired
	public CastingDAOImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<CastingDTO> selectall() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.multi.watflix.casting.dto.seletAllCasting");
	}

	@Override
	public List<CastingDTO> selectall(int movie_no) {
		System.out.println("castingDAO : ��ȭ �ѹ�"+movie_no);
		List<CastingDTO> castinglist = sqlSession.selectList("kr.multi.watflix.casting.dto.selectall", movie_no);
		return castinglist;
	}

	@Override
	public List<MovieDTO> selectList(String casting_name) {
		List<MovieDTO> castinglistsearch = sqlSession.selectList("kr.multi.watflix.casting.dto.selectallname", casting_name);
		return castinglistsearch;
	}

	

}
