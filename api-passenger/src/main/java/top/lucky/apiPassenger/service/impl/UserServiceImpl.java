package top.lucky.apiPassenger.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lucky.apiPassenger.remote.ServicePassengerUserClient;
import top.lucky.apiPassenger.service.UserService;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.dto.TokenResult;
import top.lucky.common.utils.JwtUtils;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	ServicePassengerUserClient servicePassengerUserClient;
	
	@Override
	public ResponseResult getUserByAccessToken(String accessToken) {
		log.info("获取到accessToken：{}", accessToken);
		TokenResult tokenResult = JwtUtils.checkToken(accessToken);
		String phone = tokenResult.getPhone();
		log.info("手机号：{}", phone);
		
		//查询用户信息
		ResponseResult result = servicePassengerUserClient.getUserByPhone(phone);
		return ResponseResult.success(result);
	}
}
