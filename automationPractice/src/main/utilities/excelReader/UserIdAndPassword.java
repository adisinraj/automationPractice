package excelReader;

public class UserIdAndPassword {
	
	private String UserId;
	private String password;
	
	public UserIdAndPassword(String userId, String password) {
		super();
		UserId = userId;
		this.password = password;
	}
	
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
