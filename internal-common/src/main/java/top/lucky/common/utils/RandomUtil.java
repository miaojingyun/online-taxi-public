/**
 * 
 */
package top.lucky.common.utils;

import java.util.Random;
import java.util.UUID;

/**
 *  随机数工具类
 */
public class RandomUtil {

    private final static String[] DIGITS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    private final static String[] HEXSTR_DIGITS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    private final static String[] ALLSTR_DIGITS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z" };

    /***
     * 获取数字字符串
     * 
     * @param len 指定长度
     * @return
     */
    public static String getDigitsStr(int len) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            String temp = DIGITS[random.nextInt(DIGITS.length)];

            sb.append(temp);
        }
        return sb.toString();
    }

    /***
     * 获取16进制字符串
     * 
     * @param len 指定长度
     * @return
     */
    public static String getHexStr(int len) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            String temp = HEXSTR_DIGITS[random.nextInt(HEXSTR_DIGITS.length)];

            sb.append(temp);
        }
        return sb.toString();
    }

    /***
     * 获取随机字符串
     * 
     * @param len 指定长度
     * @return
     */
    public static String getRandomStr(int len) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            String temp = ALLSTR_DIGITS[random.nextInt(ALLSTR_DIGITS.length)];

            sb.append(temp);
        }
        return sb.toString();
    }

    /***
     * 根据UUID作为引子的随机数字符串
     * 
     * @param len
     * @return
     */
    public static String getRandomUuidStr(int len) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random(UUID.randomUUID().hashCode());
        for (int i = 0; i < len; i++) {
            sb.append(random.nextInt(9));
        }

        return sb.toString();
    }

}
