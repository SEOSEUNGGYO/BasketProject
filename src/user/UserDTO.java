package user;

public class UserDTO {
	private String user_id;
	private String user_password;
	private String user_email;
	private String user_phone;
	private String user_name;
	private String user_birth;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}
	
	public UserDTO() {
		
	}
	public UserDTO(String user_id, String user_password, String user_email, String user_phone, String user_name, String user_birth) {
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_name = user_name;
		this.user_birth = user_birth;
	}
	
	
}
