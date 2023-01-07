package top.lucky.serviceprice.service;

import top.lucky.common.dto.ResponseResult;
import top.lucky.common.request.ForecastPriceDTO;

public interface PriceService {
	ResponseResult forecastPrice(ForecastPriceDTO forecastPriceDTO);
}
