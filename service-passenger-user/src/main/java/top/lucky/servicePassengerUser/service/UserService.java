package top.lucky.servicePassengerUser.service;

import top.lucky.common.dto.ResponseResult;

/**
 * @author Jane
 * @date 2022/10/9, 11:02
 */
public interface UserService {
	ResponseResult loginOrRegister(String passengerPhone);
}
