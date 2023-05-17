package kr.multi.watflix.casting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.multi.watflix.casting.dao.CastingDAO;
import kr.multi.watflix.casting.dto.CastingDTO;
import kr.multi.watflix.movie.dto.MovieDTO;

@Service
public class CastingServiceImpl implements CastingService {
	CastingDAO dao;

	@Autowired
	public CastingServiceImpl(CastingDAO dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	public List<CastingDTO> selectall() {
		// TODO Auto-generated method stub
		return dao.selectall();
	}
	
	@Override
	public List<CastingDTO> selectall(int movie_no) {
		return dao.selectall(movie_no);
	}

	@Override
	public List<MovieDTO> selectList(String casting_name) {
		return dao.selectList(casting_name);
	}

	
}
