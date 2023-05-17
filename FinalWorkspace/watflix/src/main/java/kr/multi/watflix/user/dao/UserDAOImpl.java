package kr.multi.watflix.user.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.multi.watflix.user.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	private String namespace ="kr.multi.watflix.user.dto";
	@Autowired
	SqlSession session;
	
	@Override
	public int insertmember(UserDTO user) {
		System.out.println("dao"+user.getEmail());
		return session.insert("kr.multi.watflix.user.dto.insertmember",user);
	}

	@Override
	public UserDTO login(String email, String pass) {
	    Map<String, String> map =  new HashMap<String, String>();
	    System.out.println("dao "+email);
	    map.put("email", email);
	    map.put("pass", pass);
	    return session.selectOne("kr.multi.watflix.user.dto.login", map);
	}

	@Override
	public int updatemember(UserDTO user) {
		 System.out.println("dao "+user.getFirst_name());

		return session.update("kr.multi.watflix.user.dto.updatemember" ,user);
	}

	@Override
	public void updatepassword(UserDTO user) {
		 System.out.println("dao"+user.getPass());
		  session.update("kr.multi.watflix.user.dto.updatepassword" ,user);
		  
	}

	@Override
	public UserDTO selectmember(int user_no) {
		return session.selectOne("kr.multi.watflix.user.dto.selectmember",user_no);
	}

	@Override
	public int checkemail(String email) {
		return session.selectOne("kr.multi.watflix.user.dto.selectemail",email);
	}
}
