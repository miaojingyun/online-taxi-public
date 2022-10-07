package top.lucky.apiPassenger.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.response.NumberCodeResponse;

/**
 * @author Jane
 * @date 2022/10/7, 22:52
 */
@FeignClient("service-verificationCode")
public interface ServiceVerificationCodeClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/numberCode/{size}")
	ResponseResult<NumberCodeResponse> getNumberCode(@PathVariable("size") int size);
}
