package top.lucky.driveruser.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lucky.common.dto.DriverUser;
import top.lucky.common.dto.ResponseResult;
import top.lucky.driveruser.mapper.DriverUserMapper;
import top.lucky.driveruser.service.DriverUserService;

import java.time.LocalDateTime;

@Service
@Slf4j
public class DriverUserServiceImpl implements DriverUserService {
	@Autowired
	private DriverUserMapper driverUserMapper;
	
	@Override
	public ResponseResult addUser(DriverUser driverUser) {
		int insert = driverUserMapper.insert(driverUser);
		log.info("insertResult:{}", insert);
		return ResponseResult.success();
	}
	
	public ResponseResult updateDriverUser(DriverUser driverUser){
		LocalDateTime now = LocalDateTime.now();
		driverUser.setGmtModified(now);
		driverUserMapper.updateById(driverUser);
		return ResponseResult.success("");
	}
	
}
