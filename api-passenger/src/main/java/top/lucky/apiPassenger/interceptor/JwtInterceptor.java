package top.lucky.apiPassenger.interceptor;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import top.lucky.common.constant.TokenConstants;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.dto.TokenResult;
import top.lucky.common.utils.JwtUtils;
import top.lucky.common.utils.RedisKeyUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author Jane
 * @date 2022/10/9, 16:38
 */
public class JwtInterceptor implements HandlerInterceptor {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean result = true;
		String resultStr = "";
		String token = request.getHeader("Authorization");
		//解析token
		TokenResult tokenResult = JwtUtils.checkToken(token);
		
		if (tokenResult == null) {
			resultStr = "token invalid";
			result = false;
		} else {
			
			String phone = tokenResult.getPhone();
			String identity = tokenResult.getIdentity();
			
			String tokenKey = RedisKeyUtil.generateTokenKey(phone, identity, TokenConstants.ACCESS_TOKEN_TYPE);
			//从redis取出token
			String redisToken = stringRedisTemplate.opsForValue().get(tokenKey);
			if ((StringUtils.isBlank(redisToken))||!token.equals(redisToken)) {
				resultStr = "token invalid";
				result = false;
			}
		}
		if (!result) {
			PrintWriter out = response.getWriter();
			out.println(JSONObject.fromObject(ResponseResult.fail(resultStr)));
		}
		return result;
	}
}
