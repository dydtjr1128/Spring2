package kr.ac.hansung.exception;


public class UserNotFoundException extends RuntimeException {//Exception vs RuntimeException?

	private static final long serialVersionUID = 6899309622815991017L;//class version 수정시 버전이 맞는지 안맞는지 확인하는 절차 필요

	private long userId;
	
	public UserNotFoundException(long id) {
		this.userId = id;
	}
	public long getUserId() {
		return userId;
	}	
}
