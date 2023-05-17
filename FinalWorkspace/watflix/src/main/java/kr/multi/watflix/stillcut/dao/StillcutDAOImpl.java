package kr.multi.watflix.stillcut.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.multi.watflix.stillcut.dto.StillcutDTO;

@Repository
public class StillcutDAOImpl implements StillcutDAO {
	SqlSession sqlSession;
	
	@Autowired
	public StillcutDAOImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@Override
	public List<StillcutDTO> select(int movie_no) {
		List<StillcutDTO> stillcutlist = sqlSession.selectList("kr.multi.watflix.stillcut.dto.stillcutall", movie_no);
		System.out.println(stillcutlist);
		return stillcutlist;
	}

}
