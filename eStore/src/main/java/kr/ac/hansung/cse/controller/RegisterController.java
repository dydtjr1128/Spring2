package kr.ac.hansung.cse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.cse.model.Cart;
import kr.ac.hansung.cse.model.ShippingAdress;
import kr.ac.hansung.cse.model.User;
import kr.ac.hansung.cse.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public String registerUser(Model model) {

		User user = new User();// 그냥 객체고 Spring IOC Controller가 관리하지 않음
		ShippingAdress shippingAddress = new ShippingAdress();
		
		
		user.setShippingAddress(shippingAddress);
		
		model.addAttribute("user", user);
		return "registerUser";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUserPost(@Valid User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "registerUser";
		}
		
		List<User> userList = userService.getAllUsers();
		for(User users : userList) {
			if(users.getUsername().equals(user.getUsername())) {
				model.addAttribute("usernameMsg", "username already exist");
				return "registerUser";
			}
		}
		
		user.setEnabled(true);
		if(user.getUsername().equals("admin")) {
			user.setAuthority("ROLE_ADMIN");
		}
		else {
			user.setAuthority("ROLE_USER");
		}
		Cart cart = new Cart();//빈 카트를 만들어서 넣어줘야 문제가 안생긴다. 만약에 이부분이 없다면 cart자체가 없으므로 null 이 되어 오류발생
		user.setCart(cart);
		userService.addUser(user);
		
		return "registerUserSuccess";
	}
}
