package kr.multi.watflix.controller.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.multi.watflix.casting.service.CastingService;
import kr.multi.watflix.movie.dto.MovieDTO;
import kr.multi.watflix.movie.service.MovieService;
import kr.multi.watflix.review.service.ReviewService;


@Controller
public class SearchController {
	MovieService movieService;
	ReviewService reviewService;
	CastingService castingService;
	
	
	@Autowired
	public SearchController(MovieService movieService, ReviewService reviewService, CastingService castingService) {
		super();
		this.movieService = movieService;
		this.reviewService = reviewService;
		this.castingService = castingService;
	}



	@RequestMapping(value="/search-result")
	public ModelAndView showSearchPage(String keyword, String sort,@RequestParam(defaultValue="1")int page) {
		ModelAndView mav = new ModelAndView("moviegridfw");
		List<MovieDTO> searchList = movieService.searchMovie(keyword, sort);
		mav.addObject("searchList",searchList);
		
		return mav;
	}
	
}
