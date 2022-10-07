package top.lucky.apiPassenger.service.impl;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import top.lucky.apiPassenger.service.VerificationCodeService;

/**
 * @author Jane
 * @date 2022/10/7, 18:34
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
	@Override
	public String generatorCode(String passengerPhone) {
		//调用验证码服务，获取验证码
		System.out.println("调用验证码服务，获取验证码：");
		String code = "123456";
		
		//存入redis
		System.out.println("存入redis");
		
		JSONObject result = new JSONObject();
		result.put("code", 1);
		result.put("message", "success");
		return result.toString();
	}
}
