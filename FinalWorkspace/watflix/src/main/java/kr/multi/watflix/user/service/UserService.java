package kr.multi.watflix.user.service;

import kr.multi.watflix.user.dto.UserDTO;

public interface UserService {
	public int insertMember(UserDTO user);
	
	public UserDTO login(String email,String pass);
	
	public int updatemember(UserDTO user);
	
	public void updatepassword(UserDTO user);
	
	public UserDTO selectmember(int user_no);
	
	public int checkemail(String email);


}
