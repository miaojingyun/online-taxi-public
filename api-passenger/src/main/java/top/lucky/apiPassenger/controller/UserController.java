package top.lucky.apiPassenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lucky.apiPassenger.service.UserService;
import top.lucky.common.dto.ResponseResult;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@GetMapping("/users")
	public ResponseResult getUser(HttpServletRequest request) {
		
		return userService.getUserByAccessToken(request.getHeader("Authorization"));
	}
}
