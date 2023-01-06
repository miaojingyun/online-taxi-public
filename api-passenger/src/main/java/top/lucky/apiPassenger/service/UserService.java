package top.lucky.apiPassenger.service;

import top.lucky.common.dto.ResponseResult;

public interface UserService {
	
	ResponseResult getUserByAccessToken(String accessToken);
}
