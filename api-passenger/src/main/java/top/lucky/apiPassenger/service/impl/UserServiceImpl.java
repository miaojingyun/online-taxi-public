package top.lucky.apiPassenger.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import top.lucky.apiPassenger.service.UserService;
import top.lucky.common.dto.PassengerUser;
import top.lucky.common.dto.ResponseResult;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Override
	public ResponseResult getUserByAccessToken(String accessToken) {
		log.info("获取到accessToken：{}", accessToken);
		
		
		return ResponseResult.success(new PassengerUser());
	}
}
