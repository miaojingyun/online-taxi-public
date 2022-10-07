package top.lucky.serviceVerification.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.response.NumberCodeResponse;
import top.lucky.common.utils.RandomUtil;

/**
 * @author Jane
 * @date 2022/10/7, 20:10
 */
@RestController
@Slf4j
public class NumberCodeController {
	
	@GetMapping("/numberCode/{size}")
	public ResponseResult numberCode(@PathVariable("size") int size) {
		log.info("验证码长度：【{}】", size);
		String numberCode = RandomUtil.getDigitsStr(size);
		log.info("验证码：【{}】", numberCode);
		NumberCodeResponse response = new NumberCodeResponse();
		response.setNumberCode(Integer.valueOf(numberCode));
		return ResponseResult.success(response);
	}
	
	public static void main(String[] args) {
		System.out.println(RandomUtil.getDigitsStr(5));
	}
}
