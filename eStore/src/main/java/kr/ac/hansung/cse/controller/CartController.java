package kr.ac.hansung.cse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.cse.model.User;
import kr.ac.hansung.cse.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String getCart(Model model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();//로그인 한 사용자 읽어옴
		String username = authentication.getName();//로그인 한 사용자의 이름 읽어온다.
		
		User user = userService.getUserByUserName(username);
		int cartId = user.getCart().getId();
		
		model.addAttribute("cartId",cartId);
		return "cart";
	}

}
