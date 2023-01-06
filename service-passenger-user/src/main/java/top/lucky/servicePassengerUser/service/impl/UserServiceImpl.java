package top.lucky.servicePassengerUser.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lucky.common.dto.PassengerUser;
import top.lucky.common.dto.ResponseResult;
import top.lucky.servicePassengerUser.mapper.PassengerUserMapper;
import top.lucky.servicePassengerUser.service.UserService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jane
 * @date 2022/10/9, 11:03
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PassengerUserMapper passengerUserMapper;
	@Override
	public ResponseResult loginOrRegister(String passengerPhone) {
		log.info("获取到手机号：{}",passengerPhone);
		//根据手机号查询，判断用户是否存在
		Map<String, Object> map = new HashMap<>();
		map.put("passenger_phone", passengerPhone);
		List<PassengerUser> passengerUsers = passengerUserMapper.selectByMap(map);
		if (CollectionUtils.isEmpty(passengerUsers)) {
			PassengerUser passengerUser = new PassengerUser();
			passengerUser.setPassengerGender((byte) 0);
			passengerUser.setPassengerName("lucky");
			passengerUser.setPassengerPhone(passengerPhone);
			passengerUser.setState((byte) 0);
			LocalDateTime now = LocalDateTime.now();
			passengerUser.setGmtCreate(now);
			passengerUser.setGmtModified(now);
			passengerUserMapper.insert(passengerUser);
		}
		return ResponseResult.success();
	}
}
