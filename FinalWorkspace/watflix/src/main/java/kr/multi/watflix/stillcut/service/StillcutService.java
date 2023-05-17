package kr.multi.watflix.stillcut.service;

import java.util.List;

import kr.multi.watflix.stillcut.dto.StillcutDTO;

public interface StillcutService {
	// 특정 영화에 대한 스틸컷 정보
	List<StillcutDTO> select(int movie_no);
}
