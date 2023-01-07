package top.lucky.serviceprice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.request.ForecastPriceDTO;
import top.lucky.serviceprice.service.PriceService;

@RestController
@Slf4j
public class PriceController {
	
	@Autowired
	private PriceService priceService;
	@PostMapping("forecast-price")
	public ResponseResult forecastPrice(@RequestBody ForecastPriceDTO forecastPriceDTO) {
		return priceService.forecastPrice(forecastPriceDTO);
	}
}
