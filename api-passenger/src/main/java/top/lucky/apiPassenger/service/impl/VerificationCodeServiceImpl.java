package top.lucky.apiPassenger.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import top.lucky.apiPassenger.remote.ServiceVerificationCodeClient;
import top.lucky.apiPassenger.service.VerificationCodeService;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.response.NumberCodeResponse;

import java.util.concurrent.TimeUnit;

/**
 * @author Jane
 * @date 2022/10/7, 18:34
 */
@Service
@Slf4j
public class VerificationCodeServiceImpl implements VerificationCodeService {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private ServiceVerificationCodeClient serviceVerificationCodeClient;
	
	private String verificationCodePrefix = "passenger-verification-code-";
	@Override
	public ResponseResult generatorCode(String passengerPhone) {
		ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationCodeClient.getNumberCode(6);
		int numberCode = numberCodeResponse.getData().getNumberCode();
		
		log.info("获取到验证码：【{}】", numberCode);
		//存入redis
		String key = verificationCodePrefix + passengerPhone;
		
		stringRedisTemplate.opsForValue().set(key, String.valueOf(numberCode), 2, TimeUnit.MINUTES);
		
		//通过短信服务商发送到手机
		return numberCodeResponse;
	}
}
