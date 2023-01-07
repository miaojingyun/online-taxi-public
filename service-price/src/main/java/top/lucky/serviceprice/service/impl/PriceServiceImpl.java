package top.lucky.serviceprice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.request.ForecastPriceDTO;
import top.lucky.common.utils.JacksonUtils;
import top.lucky.serviceprice.service.PriceService;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {
	@Override
	public ResponseResult forecastPrice(ForecastPriceDTO forecastPriceDTO) {
		
		log.info("dto{}", JacksonUtils.toJSONString(forecastPriceDTO));
		return null;
	}
}
