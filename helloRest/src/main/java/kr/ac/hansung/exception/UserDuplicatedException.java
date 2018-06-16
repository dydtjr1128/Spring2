package kr.ac.hansung.exception;

public class UserDuplicatedException extends RuntimeException {

	private static final long serialVersionUID = 2081249869346761091L;
	
	private String username;
		
	public UserDuplicatedException(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}	

}
