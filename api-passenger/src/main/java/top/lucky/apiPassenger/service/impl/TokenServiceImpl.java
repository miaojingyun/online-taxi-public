package top.lucky.apiPassenger.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import top.lucky.apiPassenger.service.TokenService;
import top.lucky.common.constant.TokenConstants;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.dto.TokenResult;
import top.lucky.common.enums.CommonStatusEnum;
import top.lucky.common.response.TokenResponse;
import top.lucky.common.utils.JwtUtils;
import top.lucky.common.utils.RedisKeyUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author Jane
 * @date 2022/10/9, 20:28
 */
@Service
public class TokenServiceImpl implements TokenService {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Override
	public ResponseResult refreshToken(String refreshTokenSrc) {
		//解析refreshToken
		TokenResult tokenResult = JwtUtils.checkToken(refreshTokenSrc);
		if (tokenResult == null) {
			return ResponseResult.fail(CommonStatusEnum.TOKEN_ERROR.getCode(), CommonStatusEnum.TOKEN_ERROR.getValue());
		}
		String phone = tokenResult.getPhone();
		String identity = tokenResult.getIdentity();
		
		// 去读取redis中 的refreshToken
		String refreshTokenKey = RedisKeyUtil.generateTokenKey(phone,identity, TokenConstants.REFRESH_TOKEN_TYPE);
		String refreshTokenRedis = stringRedisTemplate.opsForValue().get(refreshTokenKey);
		
		// 校验refreshToken
		if ((StringUtils.isBlank(refreshTokenRedis))  || (!refreshTokenSrc.trim().equals(refreshTokenRedis.trim()))){
			return ResponseResult.fail(CommonStatusEnum.TOKEN_ERROR.getCode(),CommonStatusEnum.TOKEN_ERROR.getValue());
		}
		
		// 生成双token
		String refreshToken = JwtUtils.generatorToken(phone,identity,TokenConstants.REFRESH_TOKEN_TYPE);
		String accessToken = JwtUtils.generatorToken(phone,identity,TokenConstants.ACCESS_TOKEN_TYPE);
		
		String accessTokenKey = RedisKeyUtil.generateTokenKey(phone,identity,TokenConstants.ACCESS_TOKEN_TYPE);
		
		stringRedisTemplate.opsForValue().set(accessTokenKey , accessToken , 30, TimeUnit.DAYS);
		stringRedisTemplate.opsForValue().set(refreshTokenKey , refreshToken , 31, TimeUnit.DAYS);
		
		TokenResponse tokenResponse = new TokenResponse();
		tokenResponse.setRefreshToken(refreshToken);
		tokenResponse.setAccessToken(accessToken);
		
		return ResponseResult.success(tokenResponse);
		
	}
}
