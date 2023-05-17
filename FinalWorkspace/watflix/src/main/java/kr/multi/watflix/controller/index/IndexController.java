package kr.multi.watflix.controller.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.multi.watflix.casting.dto.CastingDTO;
import kr.multi.watflix.casting.service.CastingService;
import kr.multi.watflix.movie.dto.MovieDTO;
import kr.multi.watflix.movie.service.MovieService;
import kr.multi.watflix.review.service.ReviewService;



@Controller
public class IndexController {
	MovieService movieService;
	ReviewService reviewService;
	CastingService castingService;
	
	
	@Autowired
	public IndexController(MovieService movieService, ReviewService reviewService, CastingService castingService) {
		super();
		this.movieService = movieService;
		this.reviewService = reviewService;
		this.castingService = castingService;
	}

	@RequestMapping("/main")
	public ModelAndView showMainMovieList() {
		List<MovieDTO> mainList = movieService.selectMovieAndRating();
		List<MovieDTO> topRated = movieService.selectListSortByRating();
		List<MovieDTO> topReviewed = movieService.selectListSortByReview();
		List<CastingDTO> castList = castingService.selectall();
		
		Map<String, List<MovieDTO>> movieMap = new HashMap<String, List<MovieDTO>>();
		movieMap.put("mainList", mainList);
		movieMap.put("topRated", topRated);
		movieMap.put("topReviewed", topReviewed);
		

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addAllObjects(movieMap);
		mav.addObject("castList", castList);

		return mav;
	}
	
	@RequestMapping("/search/movie-cast")
	public ModelAndView selectList(String casting_name) {
		ModelAndView mav = new ModelAndView("moviegridfw");
		List<MovieDTO> castingsearch = castingService.selectList(casting_name);
		mav.addObject("castingsearch", castingsearch);

		return mav;
	}
}
