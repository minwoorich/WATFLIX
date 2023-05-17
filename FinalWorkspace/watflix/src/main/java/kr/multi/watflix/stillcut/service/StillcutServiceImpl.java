package kr.multi.watflix.stillcut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.multi.watflix.stillcut.dao.StillcutDAO;
import kr.multi.watflix.stillcut.dto.StillcutDTO;

@Service
public class StillcutServiceImpl implements StillcutService {
	StillcutDAO dao;
	
	@Autowired
	public StillcutServiceImpl(StillcutDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<StillcutDTO> select(int movie_no) {
		return dao.select(movie_no);
	}

}
