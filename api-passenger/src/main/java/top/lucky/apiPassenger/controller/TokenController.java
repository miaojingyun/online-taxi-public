package top.lucky.apiPassenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.lucky.apiPassenger.service.TokenService;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.response.TokenResponse;

/**
 * @author Jane
 * @date 2022/10/9, 20:26
 */
@RestController
public class TokenController {
	
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("token-refresh")
	public ResponseResult refreshToken(@RequestBody TokenResponse tokenResponse) {
		
		return tokenService.refreshToken(tokenResponse.getRefreshToken());
	}
}

