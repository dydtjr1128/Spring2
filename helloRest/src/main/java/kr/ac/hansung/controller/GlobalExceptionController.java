package kr.ac.hansung.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.ac.hansung.exception.ErrorResponse;
import kr.ac.hansung.exception.UserDuplicatedException;
import kr.ac.hansung.exception.UserNotFoundException;

@ControllerAdvice//2개의 exception을  controller에서 던지면 여기에서 처리할 수 있다.
public class GlobalExceptionController {
	//exception 처리부분
		@ExceptionHandler(UserNotFoundException.class) 
		public ResponseEntity<ErrorResponse> handleUserNotFoundException(HttpServletRequest req, UserNotFoundException ex){
			//ErrorResponse를 body에 채워 에러를 보내 줄 예정
			
			ErrorResponse errorResponse = new ErrorResponse();
			
			String requestURL = req.getRequestURL().toString();
			errorResponse.setRequestURL(requestURL);
			errorResponse.setErrorCode("user.notfound.exception");
			errorResponse.setErrorMsg("User with id " + ex.getUserId() + " not found.");
			
			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);		
		}
		//exception 처리부분
			@ExceptionHandler(UserDuplicatedException.class)
			public ResponseEntity<ErrorResponse> handleUserDuplicatedException(HttpServletRequest req, UserDuplicatedException ex){
				//ErrorResponse를 body에 채워 에러를 보내 줄 예정
				
				ErrorResponse errorResponse = new ErrorResponse();
				
				String requestURL = req.getRequestURL().toString();
				errorResponse.setRequestURL(requestURL);
				errorResponse.setErrorCode("user.duplicated.exception");
				errorResponse.setErrorMsg("Unable to create. A user with name " + ex.getUsername() + " already exist.");
				
				return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.CONFLICT);		
			}
}
