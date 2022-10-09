package top.lucky.apiPassenger.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.utils.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author Jane
 * @date 2022/10/9, 16:38
 */
public class JwtInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean result = true;
		String resultStr = "";
		String token = request.getHeader("Authorization");
		try {
			JwtUtils.parseToken(token);
		} catch (SignatureVerificationException e) {
			resultStr = "token sign error";
			result = false;
		} catch (TokenExpiredException) {
			resultStr = "token time out";
			result = false;
		} catch (AlgorithmMismatchException e) {
			resultStr = "token AlgorithmMismatchException";
			result = false;
		} catch (Exception e) {
			resultStr = "token invalid";
			result = false;
		}
		
		if (!result) {
			PrintWriter out = response.getWriter();
			out.println(JSONObject.fromObject(ResponseResult.fail(resultStr)));
		}
		return result;
	}
}
