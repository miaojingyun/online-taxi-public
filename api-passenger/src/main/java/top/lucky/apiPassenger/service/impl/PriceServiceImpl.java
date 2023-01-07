package top.lucky.apiPassenger.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.lucky.apiPassenger.service.PriceService;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.request.ForecastPriceDTO;
import top.lucky.common.response.ForecastPriceResponse;
import top.lucky.common.utils.JacksonUtils;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {
	@Override
	public ResponseResult forecastPrice(ForecastPriceDTO forecastPriceDTO) {
		log.info("dto:{}", JacksonUtils.toJSONString(forecastPriceDTO));
		
		return ResponseResult.success(ForecastPriceResponse.builder().price(12.34).build());
	}
}
