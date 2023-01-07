package top.lucky.serviceprice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.request.ForecastPriceDTO;
import top.lucky.common.response.DirectionResponse;
import top.lucky.serviceprice.remote.ServiceMapClient;
import top.lucky.serviceprice.service.PriceService;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {
	@Autowired
	private ServiceMapClient serviceMapClient;
	
	@Override
	public ResponseResult forecastPrice(ForecastPriceDTO forecastPriceDTO) {
		
		log.info("调用地图服务，查询距离和时长");
		ResponseResult<DirectionResponse> direction = serviceMapClient.direction(forecastPriceDTO);
		Integer distance = direction.getData().getDistance();
		Integer duration = direction.getData().getDuration();
		log.info(("距离：" + distance + ",时长：" + duration));
		
		return ResponseResult.success(DirectionResponse.builder().distance(distance).duration(duration).build());
	}
}
