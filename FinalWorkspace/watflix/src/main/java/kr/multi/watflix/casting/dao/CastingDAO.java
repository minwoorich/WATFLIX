package kr.multi.watflix.casting.dao;

import java.util.List;

import kr.multi.watflix.casting.dto.CastingDTO;
import kr.multi.watflix.movie.dto.MovieDTO;

public interface CastingDAO {
	// �ش��ϴ� ��ȭ�� ��� ���
	List<CastingDTO> selectall(int movie_no);
	
	// ��� �̸� �˻�
	List<MovieDTO> selectList(String casting_name);
	
	//영화 배우 다 출력하기
	List<CastingDTO> selectall();
}
