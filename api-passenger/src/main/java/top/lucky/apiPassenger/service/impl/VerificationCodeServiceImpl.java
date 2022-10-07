package top.lucky.apiPassenger.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lucky.apiPassenger.remote.ServiceVerificationCodeClient;
import top.lucky.apiPassenger.service.VerificationCodeService;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.response.NumberCodeResponse;

/**
 * @author Jane
 * @date 2022/10/7, 18:34
 */
@Service
@Slf4j
public class VerificationCodeServiceImpl implements VerificationCodeService {
	
	@Autowired
	private ServiceVerificationCodeClient serviceVerificationCodeClient;
	@Override
	public String generatorCode(String passengerPhone) {
		ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationCodeClient.getNumberCode(7);
		int numberCode = numberCodeResponse.getData().getNumberCode();
		
		log.info("获取到验证码：【{}】", numberCode);
		//存入redis
		
		System.out.println("存入redis");
		
		JSONObject result = new JSONObject();
		result.put("code", 1);
		result.put("message", "success");
		return result.toString();
	}
}
