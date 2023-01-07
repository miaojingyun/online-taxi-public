package top.lucky.servicemap.service;

import top.lucky.common.dto.ResponseResult;

public interface DirectionService {
	ResponseResult driving(String depLongitude, String depLatitude, String destLongitude, String destLatitude);
}
