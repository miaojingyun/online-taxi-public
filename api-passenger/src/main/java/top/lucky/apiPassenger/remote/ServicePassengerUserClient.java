package top.lucky.apiPassenger.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.request.VerificationCodeDto;

/**
 * @author Jane
 * @date 2022/10/9, 14:47
 */
@FeignClient("service-passenger-user")
public interface ServicePassengerUserClient {
	
	@PostMapping("user")
	ResponseResult loginOrReg(@RequestBody VerificationCodeDto verificationCodeDto);
}
