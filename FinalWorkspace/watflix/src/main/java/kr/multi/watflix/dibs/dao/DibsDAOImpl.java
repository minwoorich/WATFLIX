package kr.multi.watflix.dibs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.multi.watflix.dibs.dto.DibsDTO;

@Repository
public class DibsDAOImpl implements DibsDAO {
	SqlSession sqlSession;

	@Autowired
	public DibsDAOImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@Override
	public int insert(DibsDTO dibsDto) {
		try {
			int insert = sqlSession.insert("kr.multi.watflix.dibs.dto.insert", dibsDto);
			sqlSession.commit();
			return insert;
		} catch(Exception e) {
			return 0;
		}
	}
	
	@Override
	public int delete(int movie_no, int user_no) {
		Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("movie_no", movie_no);
        parameter.put("user_no", user_no);
        
		int delete = sqlSession.delete("kr.multi.watflix.dibs.dto.delete", parameter);
		return delete;
	}

	@Override
	public DibsDTO select(int movie_no, int user_no) {
		Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("movie_no", movie_no);
        parameter.put("user_no", user_no);
        
        DibsDTO select = sqlSession.selectOne("kr.multi.watflix.dibs.dto.select", parameter);

        return select;
	}

	@Override
	public List<DibsDTO> selectList(int user_no) {
		List<DibsDTO> dibslist = sqlSession.selectList("kr.multi.watflix.dibs.dto.selectall",user_no);
		return dibslist;
	}

	@Override
	public int getTotalMovies(int user_no) {
		int totalmovies = sqlSession.selectOne("kr.multi.watflix.dibs.dto.totalmovies",user_no);
		return totalmovies;
	}

	@Override
	public List<DibsDTO> getDibsList(int user_no, int page, int moviesPerPage) {
		Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user_no", user_no);
        parameter.put("page", page);
        parameter.put("moviesPerPage", moviesPerPage);
        
        List<DibsDTO> dibslist = sqlSession.selectList("kr.multi.watflix.dibs.dto.dibslist", parameter);
		
		return null;
	}
}
