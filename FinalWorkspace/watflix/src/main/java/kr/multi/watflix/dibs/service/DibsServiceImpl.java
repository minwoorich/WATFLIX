package kr.multi.watflix.dibs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.multi.watflix.dibs.dao.DibsDAO;
import kr.multi.watflix.dibs.dto.DibsDTO;

@Service
public class DibsServiceImpl implements DibsService {
	DibsDAO dao;

	@Autowired
	public DibsServiceImpl(DibsDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public int insert(DibsDTO dibsDto) {
		return dao.insert(dibsDto);
	}
	
	@Override
	public int delete(int movie_no, int user_no) {
		return dao.delete(movie_no, user_no);
	}

	@Override
	public DibsDTO select(int movie_no, int user_no) {
		return dao.select(movie_no, user_no);
	}
	
	@Override
	public List<DibsDTO> selectList(int user_no) {
		return dao.selectList(user_no);
	}

	@Override
	public int getTotalMovies(int user_no) {
		return dao.getTotalMovies(user_no);
	}

	@Override
	public List<DibsDTO> getDibsList(int user_no, int page, int moviesPerPage) {
		return dao.getDibsList(user_no, page, moviesPerPage);
	}
}
