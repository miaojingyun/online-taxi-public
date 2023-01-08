package top.lucky.apiPassenger.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.request.ForecastPriceDTO;
import top.lucky.common.response.ForecastPriceResponse;

@FeignClient("service-price")
public interface ServicePriceClient {
	@RequestMapping(method = RequestMethod.POST, value = "/forecast-price")
	ResponseResult<ForecastPriceResponse> forecast(@RequestBody ForecastPriceDTO forecastPriceDTO);
}
