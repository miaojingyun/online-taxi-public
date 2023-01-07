package top.lucky.serviceprice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lucky.common.constant.CommonStatusEnum;
import top.lucky.common.dto.PriceRule;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.request.ForecastPriceDTO;
import top.lucky.common.response.DirectionResponse;
import top.lucky.serviceprice.mapper.PriceRuleMapper;
import top.lucky.serviceprice.remote.ServiceMapClient;
import top.lucky.serviceprice.service.PriceService;

import java.util.List;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {
	@Autowired
	private ServiceMapClient serviceMapClient;
	@Autowired
	private PriceRuleMapper priceRuleMapper;
	@Override
	public ResponseResult forecastPrice(ForecastPriceDTO forecastPriceDTO) {
		
		log.info("调用地图服务，查询距离和时长");
		ResponseResult<DirectionResponse> direction = serviceMapClient.direction(forecastPriceDTO);
		Integer distance = direction.getData().getDistance();
		Integer duration = direction.getData().getDuration();
		log.info(("距离：" + distance + ",时长：" + duration));
		//读取计价规则
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("city_code","110000");
		queryWrapper.eq("vehicle_type","1");
		queryWrapper.orderByDesc("fare_version");
		
		List<PriceRule> priceRules = priceRuleMapper.selectList(queryWrapper);
		if (CollectionUtils.isEmpty(priceRules)){
			return ResponseResult.fail(CommonStatusEnum.PRICE_RULE_EMPTY.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
		}
		
		PriceRule priceRule = priceRules.get(0);
		
		return ResponseResult.success(DirectionResponse.builder().distance(distance).duration(duration).build());
	}
}
