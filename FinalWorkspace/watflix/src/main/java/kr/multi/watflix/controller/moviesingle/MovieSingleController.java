package kr.multi.watflix.controller.moviesingle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.multi.watflix.casting.dto.CastingDTO;
import kr.multi.watflix.casting.service.CastingService;
import kr.multi.watflix.dibs.dto.DibsDTO;
import kr.multi.watflix.dibs.service.DibsService;
import kr.multi.watflix.movie.dto.MovieDTO;
import kr.multi.watflix.movie.service.MovieService;
import kr.multi.watflix.review.dto.ReviewDTO;
import kr.multi.watflix.review.service.ReviewService;
import kr.multi.watflix.stillcut.dto.StillcutDTO;
import kr.multi.watflix.stillcut.service.StillcutService;

@Controller
public class MovieSingleController {
	MovieService movieService;
	CastingService castingService;
	StillcutService stillcutService;
	DibsService dibsService;
	ReviewService reviewService;

	@Autowired
	public MovieSingleController(MovieService movieService, CastingService castingService,
			StillcutService stillcutService, DibsService dibsService, ReviewService reviewService) {
		super();
		this.movieService = movieService;
		this.castingService = castingService;
		this.stillcutService = stillcutService;
		this.dibsService = dibsService;
		this.reviewService = reviewService;
	}

	@RequestMapping("/movie/movie-info")
	public ModelAndView showMovieSinglePage(int movie_no, int user_no) {
		ModelAndView mav = new ModelAndView("moviesingle");

		// Movie 정보 조회
		MovieDTO movie = movieService.selectByMovieNo(movie_no);
		mav.addObject("movie", movie);

		// 출연 배우 정보 조회
		List<CastingDTO> castinglist = castingService.selectall(movie_no);
		mav.addObject("castinglist", castinglist);

		// 스틸컷 정보 조회
		List<StillcutDTO> stillcutlist = stillcutService.select(movie_no);
		mav.addObject("stillcutlist", stillcutlist);

		// 찜한 여부 조회
		DibsDTO dibs = dibsService.select(movie_no, user_no);
		mav.addObject("dibs", dibs);

		// 평균 별점 조회
		double review = reviewService.selectAvgRating(movie_no);
		mav.addObject("reviewAvg", review);
		
		//내 영화리뷰 가져오기
		List<ReviewDTO> myReviewList = reviewService.selectReviewListByUserNoAndMovieNo(movie_no, user_no);
		mav.addObject("myReviewList", myReviewList);
		
		//영화에 대한 리뷰 가져오기
		List<ReviewDTO> reviewlist = reviewService.selectall(movie_no);
		mav.addObject("reviewlist", reviewlist);

		return mav;
	}

	@RequestMapping("/dibs/insert")
	public String insert(DibsDTO dibsDto) {
		int movie_no = dibsDto.getMovie_no();
		int user_no = dibsDto.getUser_no();
		dibsService.insert(dibsDto);
		return "redirect:/movie/movie-info?movie_no=" + movie_no + "&user_no=" + user_no;
	}

	@RequestMapping("/dibs/delete")
	public String delete(int movie_no, int user_no) {
		dibsService.delete(movie_no, user_no);
		return "redirect:/movie/movie-info?movie_no=" + movie_no + "&user_no=" + user_no;
	}

	@RequestMapping("/dibs/select")
	@ResponseBody
	public ResponseEntity<?> selectDibs(int movie_no, int user_no) {
		DibsDTO dibs = dibsService.select(movie_no, user_no);
		if (dibs != null) {
			return ResponseEntity.ok(dibs);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	///////////// 리뷰 파트////////////////////
	
	@RequestMapping("/review/write")
	public String write(int movie_no, Model model) {
		model.addAttribute("movie_no",movie_no);
		return "review_write";
	}

	@RequestMapping("/review/insert")
	public String insert(ReviewDTO review) {
		System.out.println(review);
		reviewService.insert(review);
		int movie_no = review.getMovie_no();
		int user_no = review.getUser_no();
		return "redirect:/movie/movie-info?movie_no="+movie_no+"&user_no="+user_no;
	}
	
	

}
