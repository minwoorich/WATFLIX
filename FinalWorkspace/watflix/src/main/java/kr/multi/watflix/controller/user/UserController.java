package kr.multi.watflix.controller.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.multi.watflix.dibs.dto.DibsDTO;
import kr.multi.watflix.dibs.service.DibsService;
import kr.multi.watflix.movie.dto.MovieDTO;
import kr.multi.watflix.movie.service.MovieService;
import kr.multi.watflix.user.dto.UserDTO;
import kr.multi.watflix.user.service.UserService;

@Controller
public class UserController {
	
	private UserService userservice;
	private DibsService dibsService;
	private MovieService movieService;
	
	
	
	@Autowired
	public UserController(UserService userservice, DibsService dibsService, MovieService movieService) {
		super();
		this.userservice = userservice;
		this.dibsService = dibsService;
		this.movieService = movieService;
	}



	@RequestMapping(value="/view/register.do") 
	public String insert(UserDTO user) {
		System.out.println("controller"+user.getEmail());
		userservice.insertMember(user);
		System.out.println(userservice.insertMember(user));
		return "redirect:/main";
	}
	
	
	
	@RequestMapping(value="/view/login.do",produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String login(@RequestBody Map<String,Object>map, HttpServletRequest request) {
		String msg="";
		String email = (String)map.get("email");
		String pass = (String)map.get("pass");
		System.out.println("email : "+email);
		System.out.println("pass : "+pass);
		
		
		UserDTO user = userservice.login(email, pass);
		
		if(user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginuser", user);
			System.out.println("로그인성공");
			msg="로그인 성공";
			
		}else {
			msg = "아이디/비밀번호가 다릅니다";
			System.out.println("로그인실패");
		}	

		return msg;
		
	}
	@RequestMapping("/user/logout.do")
	public  String logout(HttpSession session) {
		if(session!=null) {
			session.invalidate();
			System.out.println("로그아웃 성공");
		}
		
		return "redirect:/main";
	}
	@RequestMapping(value="/user/update.do", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String formupdate(@RequestBody UserDTO user) {
		
		System.out.println("������Ʈ"+user.getFirst_name());
		userservice.updatemember(user);
		return "redirect:/";
	}
	@RequestMapping("/user/user-profile")
	public String showUserProfilePage() {
		return "userprofile";
	}
	
	@RequestMapping("/user/changepassword.do")
	public String ChangePassoword(UserDTO user,BindingResult result,HttpSession session, Model model) {
		UserDTO db_user = (UserDTO)session.getAttribute("loginUser");
		if(!db_user.getPass().equals(user.getNow_pass()));{
			result.rejectValue("error","");
		}
		userservice.updatemember(user);
		return "redirect:/user/login";
	}
	@RequestMapping(value= "/sign-up/passChk", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String chkPassDuplicate(@RequestBody Map<String,Object> data) {
		String pass = (String)data.get("pass");
		String repass = (String)data.get("repass");
		System.out.println("pass : " + pass);
		System.out.println("repass : " + repass);
		String msg = "";
		if(!pass.equals(repass)) {
			
			msg = "비밀번호가 다릅니다";
		}else {
			msg="비밀번호가 서로 같습니다";
		}
		System.out.println("유저컨트롤러 ckPassDuplicate -> msg : " + msg);
		return msg;
	}
	
	// 영화 + 별점 + 내가 찜한
	@RequestMapping("/user/my-favorite")
	public ModelAndView selectMovieListDibs(int user_no){
		ModelAndView mav = new ModelAndView("userfavoritegrid");
		List<MovieDTO> myDibbedMovieList = movieService.selectDibbedMovieAndRating(user_no);
		mav.addObject("myDibbedMovieList",myDibbedMovieList);

		System.out.println("controller"+user_no);
		return mav;
	}
	
	// 영화 + 별점 + 내가 리뷰한
	@RequestMapping("/user/my-reviewed")
	public ModelAndView selectMovieListReviewed(int user_no){
		ModelAndView mav = new ModelAndView("userrate");
		List<MovieDTO> myReviewedMovieList = movieService.selectReviewedMovieAndRating(user_no);
		mav.addObject("myReviewedMovieList",myReviewedMovieList);

		System.out.println("controller"+user_no);
		return mav;
	}
	
}
