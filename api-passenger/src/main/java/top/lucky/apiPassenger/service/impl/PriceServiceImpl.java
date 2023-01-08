package top.lucky.apiPassenger.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lucky.apiPassenger.remote.ServicePriceClient;
import top.lucky.apiPassenger.service.PriceService;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.request.ForecastPriceDTO;
import top.lucky.common.response.ForecastPriceResponse;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {
	@Autowired
	private ServicePriceClient servicePriceClient;
	@Override
	public ResponseResult forecastPrice(ForecastPriceDTO forecastPriceDTO) {
		ResponseResult<ForecastPriceResponse> forecast = servicePriceClient.forecast(forecastPriceDTO);
		
		return ResponseResult.success(forecast.getData());
	}
	
}
