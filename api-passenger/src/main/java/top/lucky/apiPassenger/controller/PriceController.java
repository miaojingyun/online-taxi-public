package top.lucky.apiPassenger.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.lucky.apiPassenger.service.PriceService;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.request.ForecastPriceDTO;
import top.lucky.common.utils.JacksonUtils;

@RestController
@Slf4j
public class PriceController {
	
	@Autowired
	private PriceService priceService;
	@PostMapping("forecast-price")
	public ResponseResult forecastPrice(@RequestBody ForecastPriceDTO forecastPriceDTO) {
		
		log.info("dto:{}", JacksonUtils.toJSONString(forecastPriceDTO));
		
		return priceService.forecastPrice(forecastPriceDTO);
	}
}
