package kr.multi.watflix.user.dao;

import kr.multi.watflix.user.dto.UserDTO;

public interface UserDAO {
	
	public int insertmember(UserDTO user);
	
	public UserDTO login(String email,String pass);
	
	public int updatemember(UserDTO user);
	
	public void updatepassword(UserDTO user);
	
	public UserDTO selectmember(int user_no);
	
	public int checkemail(String email);
	
	
}
