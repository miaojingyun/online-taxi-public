package top.lucky.apiPassenger.service;

import top.lucky.common.dto.ResponseResult;

/**
 * @author Jane
 * @date 2022/10/9, 20:28
 */
public interface TokenService {
	
	ResponseResult refreshToken(String refreshTokenSrc);
}
