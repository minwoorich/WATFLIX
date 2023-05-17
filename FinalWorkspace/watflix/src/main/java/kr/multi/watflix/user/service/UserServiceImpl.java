package kr.multi.watflix.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.multi.watflix.user.dao.UserDAO;
import kr.multi.watflix.user.dto.UserDTO;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userdao;
	
	@Override
	public int insertMember(UserDTO user) {
	 return	userdao.insertmember(user);
	}

	@Override
	public UserDTO login(String email, String pass) {
		System.out.println("service "+email);
		return userdao.login(email, pass);
		
		
	}

	@Override
	public int updatemember(UserDTO user) {
		 System.out.println("service"+user.getLast_name());

		return userdao.updatemember(user);
	}

	@Override
	public void updatepassword(UserDTO user) {
		userdao.updatepassword(user);
	}

	@Override
	public UserDTO selectmember(int user_no) {
		return userdao.selectmember(user_no);
	}

	@Override
	public int checkemail(String email) {
		
		return userdao.checkemail(email);
	}

}

