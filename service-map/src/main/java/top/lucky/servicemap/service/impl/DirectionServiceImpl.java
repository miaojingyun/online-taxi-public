package top.lucky.servicemap.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lucky.common.dto.ResponseResult;
import top.lucky.servicemap.remote.MapDirectionClient;
import top.lucky.servicemap.service.DirectionService;

@Service
@Slf4j
public class DirectionServiceImpl implements DirectionService {
	
	@Autowired
	private MapDirectionClient mapDirectionClient;
	@Override
	public ResponseResult driving(String depLongitude, String depLatitude, String destLongitude, String destLatitude) {
		return ResponseResult.success(mapDirectionClient.direction(depLongitude, depLatitude, destLongitude, destLatitude));
	}
}
