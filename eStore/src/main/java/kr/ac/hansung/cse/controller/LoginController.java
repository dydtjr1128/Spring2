package kr.ac.hansung.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, 
			@RequestParam(value="logout", required=false) String logout, Model model) {
		//error라는 파라미터로 값을 받음
		//required는 이 error라는 파라미터가 꼭 있어야 하느냐 디폴트가 true이므로 없어도 된다고 false로 변경
		
		if(error != null) {
			model.addAttribute("errorMsg", "Invalid username and password");
		}
		
		if(logout != null) {
			model.addAttribute("logoutMsg", "You have been logged out successfully");
		}
			
		
		return "login";
	}	

}
