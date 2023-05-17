package kr.multi.watflix.user.dto;

import java.sql.Timestamp;

public class UserDTO {
	private int user_no;
	private String email;
	private String  pass;
	private String first_name;
	private String last_name;
	private String nickname;
	private Timestamp register_date;
	private Timestamp update_date;
	private String image;
	private String  now_pass;
	public int getUser_no() {
		return user_no;
	}
	public String getNow_pass() {
		return now_pass;
	}
	public void setNow_pass(String now_pass) {
		this.now_pass = now_pass;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserDTO [user_no=" + user_no + ", email=" + email + ", pass=" + pass + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", nickname=" + nickname + ", register_date=" + register_date
				+ ", update_date=" + update_date + ", image=" + image + ", now_pass=" + now_pass + "]";
	}
	public UserDTO(int user_no, String email, String pass, String first_name, String last_name, String nickname,
			Timestamp register_date, Timestamp update_date, String image) {
		super();
		this.user_no = user_no;
		this.email = email;
		this.pass = pass;
		this.first_name = first_name;
		this.last_name = last_name;
		this.nickname = nickname;
		this.register_date = register_date;
		this.update_date = update_date;
		this.image = image;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	// update �� dto
	public UserDTO(int user_no, String email, String pass, String first_name, String last_name, String nickname,
			Timestamp update_date) {
		super();
		this.user_no = user_no;
		this.email = email;
		this.pass = pass;
		this.first_name = first_name;
		this.last_name = last_name;
		this.nickname = nickname;
		this.update_date = update_date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Timestamp getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Timestamp register_date) {
		this.register_date = register_date;
	}
	public Timestamp getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
