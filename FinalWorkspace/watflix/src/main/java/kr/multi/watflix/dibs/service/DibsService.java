package kr.multi.watflix.dibs.service;

import java.util.List;

import kr.multi.watflix.dibs.dto.DibsDTO;

public interface DibsService {
	// 찜하기 생성
	int insert(DibsDTO dibsDto);
	
	// 찜하기 삭제
	int delete(int movie_no, int user_no);
	
	// 찜하기 여부
	DibsDTO select(int movie_no, int user_no);
	
	// 내가 찜한 영화 목록
	List<DibsDTO> selectList(int user_no);
	
	// 찜한 영화 전체 갯수
	public int getTotalMovies(int user_no);
	
	// 찜한 영화 전체 페이지 갯수
	public List<DibsDTO> getDibsList(int user_no, int page, int moviesPerPage);
}
