package top.lucky.apiPassenger.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import top.lucky.apiPassenger.remote.ServiceVerificationCodeClient;
import top.lucky.apiPassenger.service.VerificationCodeService;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.enums.CommonStatusEnum;
import top.lucky.common.response.NumberCodeResponse;
import top.lucky.common.response.TokenResponse;

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
		String key = getString(passengerPhone);
		
		stringRedisTemplate.opsForValue().set(key, String.valueOf(numberCode), 2, TimeUnit.MINUTES);
		
		//通过短信服务商发送到手机
		return numberCodeResponse;
	}
	
	/**
	 * 生成key
	 * @param passengerPhone
	 * @return
	 */
	private String getString(String passengerPhone) {
		String key = verificationCodePrefix + passengerPhone;
		return key;
	}
	
	@Override
	public ResponseResult verificationCheck(String passengerPhone, String verificationCode) {
		log.info("获取到手机号：{},验证码{}", passengerPhone, verificationCode);
		String verifyCode = stringRedisTemplate.opsForValue().get(verificationCodePrefix + passengerPhone);
		if (StringUtils.isEmpty(verifyCode)) {
			return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_MISS.getCode(), CommonStatusEnum.VERIFICATION_CODE_MISS.getValue());
		}
		log.info("获取到redis中验证码为：{}", verifyCode);
		if (!verificationCode.equals(verifyCode)) {
			return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),  CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
			
		}
		TokenResponse response = new TokenResponse();
		response.setAccessToken("token");
		return ResponseResult.success(response);
	}
}
