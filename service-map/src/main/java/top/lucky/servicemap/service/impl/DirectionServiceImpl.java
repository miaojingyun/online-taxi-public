package top.lucky.servicemap.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.response.DirectionResponse;
import top.lucky.servicemap.service.DirectionService;

@Service
@Slf4j
public class DirectionServiceImpl implements DirectionService {
	@Override
	public ResponseResult driving(String depLongitude, String depLatitude, String destLongitude, String destLatitude) {
		DirectionResponse directionResponse = new DirectionResponse();
		directionResponse.setDistance(12);
		directionResponse.setDuration(123);
		return ResponseResult.success(directionResponse);
	}
}
