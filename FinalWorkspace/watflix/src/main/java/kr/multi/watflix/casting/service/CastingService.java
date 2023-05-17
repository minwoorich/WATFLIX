package kr.multi.watflix.casting.service;

import java.util.List;
import kr.multi.watflix.casting.dto.CastingDTO;
import kr.multi.watflix.movie.dto.MovieDTO;

public interface CastingService {
	// �ش��ϴ� ��ȭ�� ��� ���
	List<CastingDTO> selectall(int movie_no);
	
	// 모든 배우 출력
	List<CastingDTO> selectall();
	
	// ��� �̸� �˻�
	List<MovieDTO> selectList(String casting_name);
}
