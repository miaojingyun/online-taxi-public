package top.lucky.servicemap.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.request.ForecastPriceDTO;
import top.lucky.servicemap.service.DirectionService;

@RestController
@Slf4j
@RequestMapping("/direction")
public class DirectionController {
	
	@Autowired
	private DirectionService directionService;
	@GetMapping("/driving")
	public ResponseResult driving(@RequestBody ForecastPriceDTO forecastPriceDTO) {
		String depLongitude = forecastPriceDTO.getDepLongitude();
		String depLatitude = forecastPriceDTO.getDepLatitude();
		String destLongitude = forecastPriceDTO.getDestLongitude();
		String destLatitude = forecastPriceDTO.getDestLatitude();
		
		return directionService.driving(depLongitude,depLatitude,destLongitude,destLatitude);
	}
}
