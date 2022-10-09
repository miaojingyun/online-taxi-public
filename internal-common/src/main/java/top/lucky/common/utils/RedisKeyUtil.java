package top.lucky.common.utils;

/**
 * @author Jane
 * @date 2022/10/9, 19:40
 */
public class RedisKeyUtil {
	private static String verificationCodePrefix = "passenger-verification-code-";
	private static String tokenPrefix = "token-";
	
	
	
	/**
	 * 生成key
	 * @param passengerPhone
	 * @return
	 */
	public static String generateKeyByPhone(String passengerPhone) {
		String key = verificationCodePrefix + passengerPhone;
		return key;
	}
	
	/**
	 * 生成token 的key
	 * @param passengerPhone
	 * @return
	 */
	/**
	 * 根据手机号和身份标识，生成token
	 * @param phone
	 * @param identity
	 * @return
	 */
	public static String generateTokenKey(String phone , String identity){
		return tokenPrefix + phone + "-" + identity;
	}
}
